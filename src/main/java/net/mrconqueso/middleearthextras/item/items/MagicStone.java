package net.mrconqueso.middleearthextras.item.items;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtOps;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class MagicStone extends Item {
    public MagicStone(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient && user.isSneaking()) {
            Optional<GlobalPos> pos = getPosition(stack);
            if (pos.isPresent()) {
                clearPosition(stack);
                user.sendMessage(Text.translatable("messages.middle-earth-extras.palantir.cleared"), true);
                return TypedActionResult.success(stack);
            }
        }
        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        Optional<GlobalPos> posOpt = getPosition(stack);
        if (posOpt.isPresent()) {
            GlobalPos pos = posOpt.get();
            tooltip.add(Text.literal(Text.translatable("item.middle-earth-extras.magic_stone.tooltip.linked") + pos.dimension().getValue().toString() + " [" + pos.pos().toShortString() + "]").formatted(Formatting.GRAY));
        } else {
            tooltip.add(Text.translatable("item.middle-earth-extras.magic_stone.tooltip.nopos").formatted(Formatting.GRAY));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }

    public static void setPosition(ItemStack stack, GlobalPos pos) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        GlobalPos.CODEC.encodeStart(NbtOps.INSTANCE, pos)
                .resultOrPartial(err -> {})
                .ifPresent(tag -> nbt.put("StoredPalantirPos", tag));
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }

    public static Optional<GlobalPos> getPosition(ItemStack stack) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        if (nbt.contains("StoredPalantirPos")) {
            return GlobalPos.CODEC.parse(NbtOps.INSTANCE, nbt.get("StoredPalantirPos"))
                    .resultOrPartial(err -> {})
                    .map(Optional::of)
                    .orElse(Optional.empty());
        }
        return Optional.empty();
    }

    public static void clearPosition(ItemStack stack) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();
        nbt.remove("StoredPalantirPos");
        stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }
}
