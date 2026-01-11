package net.mrconqueso.middleearthextras.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.mrconqueso.middleearthextras.world.structure.protection.AStructureUtils;
import net.mrconqueso.middleearthextras.world.structure.protection.StructurePlacementState;

public class FreeAreaCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess,CommandManager.RegistrationEnvironment environment) {
        dispatcher.register(CommandManager.literal("freearea").executes(FreeAreaCommand::run));
    }

    private static int run(CommandContext<ServerCommandSource> context) {

        ServerWorld world = context.getSource().getWorld();
        BlockPos bossPos = context.getSource().getEntity().getBlockPos();

        var structureIds = AStructureUtils.getStructuresAt(world, bossPos);
        if (structureIds.isEmpty()) return 0;

        for (var structureId : structureIds) {
            String instanceKey = AStructureUtils.getStructureInstanceKey(world, bossPos, structureId);
            StructurePlacementState.get(world).unlockInstance(instanceKey);
        }
        return 1;
    }
}
