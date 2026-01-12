package net.mrconqueso.middleearthextras.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import net.mrconqueso.middleearthextras.util.PossessesCamera;

public class PalantirNetwork {
    public static final Identifier PALANTIR_SYNC_ID = Identifier.of(MiddleEarthExtras.MOD_ID, "palantir_sync");
    public static final Identifier PALANTIR_EXIT_ID = Identifier.of(MiddleEarthExtras.MOD_ID, "palantir_exit");
    public static final Identifier PALANTIR_ZOOM_ID = Identifier.of(MiddleEarthExtras.MOD_ID, "palantir_zoom");

    public static void register() {
        PayloadTypeRegistry.playS2C().register(PalantirSyncPayload.ID, PalantirSyncPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(PalantirExitPayload.ID, PalantirExitPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(PalantirZoomPayload.ID, PalantirZoomPayload.CODEC);

        // Server-side handler for exit packet
        ServerPlayNetworking.registerGlobalReceiver(PalantirExitPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                // Get the entity using the ID from the payload
                Entity entity = context.player().getWorld().getEntityById(payload.entityId());
                if (entity instanceof PossessesCamera camera) {
                    camera.onPossessionKeyPacket(context.player(), 0);
                }
            });
        });

        // Server-side handler for zoom packet
        ServerPlayNetworking.registerGlobalReceiver(PalantirZoomPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                Entity cameraEntity = context.player().getCameraEntity();
                if (cameraEntity instanceof net.mrconqueso.middleearthextras.entity.misc.PalantirViewEntity palantirView) {
                    palantirView.updateZoom(payload.zoomDelta());
                }
            });
        });
    }

    // --- Payloads ---

    public record PalantirSyncPayload(int entityId, boolean active) implements CustomPayload {
        public static final CustomPayload.Id<PalantirSyncPayload> ID = new CustomPayload.Id<>(PALANTIR_SYNC_ID);
        public static final PacketCodec<RegistryByteBuf, PalantirSyncPayload> CODEC = PacketCodec.tuple(
                PacketCodecs.INTEGER, PalantirSyncPayload::entityId,
                PacketCodecs.BOOL, PalantirSyncPayload::active,
                PalantirSyncPayload::new
        );

        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }

    public record PalantirExitPayload(int entityId) implements CustomPayload {
        public static final CustomPayload.Id<PalantirExitPayload> ID = new CustomPayload.Id<>(PALANTIR_EXIT_ID);
        public static final PacketCodec<RegistryByteBuf, PalantirExitPayload> CODEC = PacketCodec.tuple(
                PacketCodecs.INTEGER, PalantirExitPayload::entityId,
                PalantirExitPayload::new
        );

        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }

    public record PalantirZoomPayload(float zoomDelta) implements CustomPayload {
        public static final CustomPayload.Id<PalantirZoomPayload> ID = new CustomPayload.Id<>(PALANTIR_ZOOM_ID);
        public static final PacketCodec<RegistryByteBuf, PalantirZoomPayload> CODEC = PacketCodec.tuple(
                PacketCodecs.FLOAT, PalantirZoomPayload::zoomDelta,
                PalantirZoomPayload::new
        );

        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }
}