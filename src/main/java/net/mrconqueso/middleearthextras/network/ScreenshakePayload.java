package net.mrconqueso.middleearthextras.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ScreenshakePayload(float intensity, int duration) implements CustomPayload {
    public static final Identifier SHAKE_PACKET_ID = Identifier.of("camerashake", "shake");

    public static final CustomPayload.Id<ScreenshakePayload> ID = new CustomPayload.Id<>(SHAKE_PACKET_ID);
    public static final PacketCodec<RegistryByteBuf, ScreenshakePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.FLOAT, ScreenshakePayload::intensity,
            PacketCodecs.INTEGER, ScreenshakePayload::duration,
            ScreenshakePayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}