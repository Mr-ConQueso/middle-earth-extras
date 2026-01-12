package net.mrconqueso.middleearthextras.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.mrconqueso.middleearthextras.block.entity.PalantirBlockEntity;
import net.mrconqueso.middleearthextras.item.items.MagicStone;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class PalantirBlock extends BlockWithEntity implements BlockEntityProvider {

    public static VoxelShape makeShape() {
        return VoxelShapes.union(
                VoxelShapes.cuboid(0.1875, 0, 0.1875, 0.8125, 0.1875, 0.8125),
                VoxelShapes.cuboid(0.3125, 0.1875, 0.3125, 0.6875, 0.28125, 0.6875),
                VoxelShapes.cuboid(0.25, 0.28125, 0.25, 0.75, 0.78125, 0.75)
        );
    }

    public static final MapCodec<PalantirBlock> CODEC = createCodec(PalantirBlock::new);

    public PalantirBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        if (world.isClient) {
            return ItemActionResult.SUCCESS;
        }

        if (player instanceof ServerPlayerEntity serverPlayer) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof PalantirBlockEntity palantir) {

                // Logic for Magic Stone interaction
                if (stack.getItem() instanceof MagicStone) {
                    GlobalPos currentPos = GlobalPos.create(world.getRegistryKey(), pos);
                    Optional<GlobalPos> storedPosOpt = MagicStone.getPosition(stack);

                    if (storedPosOpt.isPresent()) {
                        GlobalPos storedPos = storedPosOpt.get();

                        // Don't link to itself
                        if (storedPos.equals(currentPos)) {
                            player.sendMessage(Text.translatable("messages.middle-earth-extras.palantir.to_self"), true);
                            return ItemActionResult.FAIL;
                        }

                        // Try to find the other Palantir
                        ServerWorld otherWorld = serverPlayer.getServer().getWorld(storedPos.dimension());
                        if (otherWorld != null) {
                            BlockEntity otherBe = otherWorld.getBlockEntity(storedPos.pos());
                            
                            if (otherBe instanceof PalantirBlockEntity otherPalantir) {
                                // Link both
                                palantir.link(storedPos);
                                otherPalantir.link(currentPos);
                                
                                player.sendMessage(Text.translatable("messages.middle-earth-extras.palantir.link_success"), true);
                                return ItemActionResult.SUCCESS;
                            } else {
                                player.sendMessage(Text.translatable("messages.middle-earth-extras.palantir.unreachable"), true);
                            }
                        }
                    } else {
                        // Save current position to stone
                        MagicStone.setPosition(stack, currentPos);
                        player.sendMessage(Text.translatable("messages.middle-earth-extras.palantir.position_saved"), true);
                        return ItemActionResult.SUCCESS;
                    }
                } 
                // Logic for Possession (Empty hand or non-MagicStone item usage handling)
                else {
                    palantir.usePalantir(serverPlayer);
                    return ItemActionResult.CONSUME;
                }
            }
        }
        return ItemActionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PalantirBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return makeShape();
    }
}