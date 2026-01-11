package net.mrconqueso.middleearthextras.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.mrconqueso.middleearthextras.util.WorldStructureData;

public class StructurePosCommand {

    private static final SuggestionProvider<ServerCommandSource> SUGGEST_STRUCTURES = (context, builder) -> {
        ServerWorld world = context.getSource().getWorld();
        WorldStructureData data = WorldStructureData.get(world);
        return CommandSource.suggestMatching(data.getStructureNames(), builder);
    };

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess registryAccess, CommandManager.RegistrationEnvironment environment) {
        dispatcher.register(CommandManager.literal("getstructurepos")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("list")
                        .executes(context -> {
                            ServerWorld world = context.getSource().getWorld();
                            WorldStructureData data = WorldStructureData.get(world);

                            if (data.getStructureNames().isEmpty()) {
                                context.getSource().sendFeedback(() -> Text.literal("No custom structures recorded yet.").formatted(Formatting.YELLOW), false);
                                return 1;
                            }

                            context.getSource().sendFeedback(() -> Text.literal("Known Structures:").formatted(Formatting.GOLD), false);
                            for (String name : data.getStructureNames()) {
                                BlockPos pos = data.getPosition(name);
                                context.getSource().sendFeedback(() -> Text.literal(" - " + name + ": " + pos.toShortString()).formatted(Formatting.WHITE), false);
                            }
                            return 1;
                        })
                )
                .then(CommandManager.argument("name", StringArgumentType.string())
                        .suggests(SUGGEST_STRUCTURES)
                        .executes(context -> {
                            String name = StringArgumentType.getString(context, "name");
                            ServerWorld world = context.getSource().getWorld();
                            WorldStructureData data = WorldStructureData.get(world);

                            BlockPos pos = data.getPosition(name);
                            if (pos != null) {
                                context.getSource().sendFeedback(() -> Text.literal("Structure '" + name + "' is at: " + pos.toShortString()).formatted(Formatting.GREEN), false);
                            } else {
                                context.getSource().sendError(Text.literal("Structure '" + name + "' position not recorded."));
                            }
                            return 1;
                        }))
        );
    }
}