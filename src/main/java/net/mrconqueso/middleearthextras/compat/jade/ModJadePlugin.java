package net.mrconqueso.middleearthextras.compat.jade;

import net.jukoz.me.entity.beasts.trolls.petrified.PetrifiedTrollEntity;
import net.minecraft.block.Blocks;
import net.mrconqueso.middleearthextras.block.ModBlocks;
import snownee.jade.api.*;

@WailaPlugin
public class ModJadePlugin implements IWailaPlugin {

    @Override
    public void register(IWailaCommonRegistration registration) {
        //TODO register data providers
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {

        registration.registerEntityComponent(PetrifiedTrollComponentProvider.INSTANCE, PetrifiedTrollEntity.class);

        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor instanceof BlockAccessor blockAccessor) {
                if (blockAccessor.getBlock() == ModBlocks.DAMP_TORCH) {
                    return registration.blockAccessor().from(blockAccessor).blockState(Blocks.TORCH.getDefaultState()).build();
                } else if (blockAccessor.getBlock() == ModBlocks.WALL_DAMP_TORCH) {
                    return registration.blockAccessor().from(blockAccessor).blockState(Blocks.WALL_TORCH.getDefaultState()).build();
                }
            }
            return accessor;
        });
    }
}
