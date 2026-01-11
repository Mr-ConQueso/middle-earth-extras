package net.mrconqueso.middleearthextras.world.structure;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.structure.StructureType;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.world.structure.gen.SavingJigsawStructure;
import net.mrconqueso.middleearthextras.world.structure.gen.moria.MoriaGateStructure;
import net.mrconqueso.middleearthextras.world.structure.gen.mountDoom.MountDoomGateStructure;

public class ModStructureTypes {
    public static StructureType<MoriaGateStructure> MORIA_GATE;
    public static StructureType<MountDoomGateStructure> MOUNT_DOOM_GATE;
    public static StructureType<SavingJigsawStructure> SAVING_JIGSAW;
    public static StructurePieceType MORIA_PIECE;

    public static void register() {
        MORIA_GATE = Registry.register(
                Registries.STRUCTURE_TYPE,
                Identifier.of(MiddleEarthExtras.MOD_ID, "moria_gate"),
                () -> MoriaGateStructure.CODEC
        );

        MORIA_PIECE = Registry.register(
                Registries.STRUCTURE_PIECE,
                Identifier.of(MiddleEarthExtras.MOD_ID, "moria_piece"),
                MoriaGateStructure.MoriaPiece::new
        );

        MOUNT_DOOM_GATE = Registry.register(
                Registries.STRUCTURE_TYPE,
                Identifier.of(MiddleEarthExtras.MOD_ID, "mount_doom_gate"),
                () -> MountDoomGateStructure.CODEC
        );

        SAVING_JIGSAW = Registry.register(
                Registries.STRUCTURE_TYPE,
                Identifier.of(MiddleEarthExtras.MOD_ID, "saving_jigsaw"),
                () -> SavingJigsawStructure.CODEC
        );

        registerStructureTypes();
    }

    public static void registerStructureTypes() {
        MiddleEarthExtras.LOGGER.info("Registering Structure Types for " + MiddleEarthExtras.MOD_ID);
    }
}
