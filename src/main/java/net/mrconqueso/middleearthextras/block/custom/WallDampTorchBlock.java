package net.mrconqueso.middleearthextras.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.mrconqueso.middleearthextras.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class WallDampTorchBlock extends WallTorchBlock {
    public WallDampTorchBlock(Settings settings) {
        super(ParticleTypes.SMOKE, settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.7;
        double f = (double)pos.getZ() + 0.5;

        // Spawn a "Smoke" particle only (no fire) to show it's extinguished
        if (random.nextInt(5) == 0) { // Occasional puff
            world.addParticle(ParticleTypes.SMOKE, d, e, f, 0.0, 0.0, 0.0);
        }
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(Blocks.TORCH);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.getBiome(pos).isIn(ModTags.Biomes.DARK_BIOMES)) {
            super.onPlaced(world, pos, state, placer, itemStack);
        }
        else  {
            BlockState vanillaState = Blocks.WALL_TORCH.getDefaultState()
                    .with(WallTorchBlock.FACING, state.get(WallTorchBlock.FACING));
            world.setBlockState(pos, vanillaState, 3);
        }
    }
}
