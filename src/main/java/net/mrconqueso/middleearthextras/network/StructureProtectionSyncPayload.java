package net.mrconqueso.middleearthextras.network;

import net.minecraft.block.Block;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.mrconqueso.middleearthextras.MiddleEarthExtras;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public record StructureProtectionSyncPayload(
        boolean inProtectedStructure,
        Set<Long> playerPlacedBlocks,
        @Nullable TagKey<Block> protectedBlocksTag,
        @Nullable TagKey<Block> breakableBlocksTag
) implements CustomPayload {

    public static final CustomPayload.Id<StructureProtectionSyncPayload> ID =
            new CustomPayload.Id<>(Identifier.of(MiddleEarthExtras.MOD_ID, "structure_protection_sync"));

    // Codec for Identifier that works with RegistryByteBuf
    private static final PacketCodec<RegistryByteBuf, Identifier> IDENTIFIER_CODEC = 
            Identifier.PACKET_CODEC.cast();

    // Custom codec for Optional<TagKey<Block>> using the tag's identifier
    private static final PacketCodec<RegistryByteBuf, Optional<TagKey<Block>>> OPTIONAL_BLOCK_TAG_CODEC =
            PacketCodecs.optional(IDENTIFIER_CODEC).xmap(
                    // Decode: Identifier -> TagKey<Block>
                    opt -> opt.map(id -> TagKey.of(RegistryKeys.BLOCK, id)),
                    // Encode: TagKey<Block> -> Identifier
                    opt -> opt.map(TagKey::id)
            );

    public static final PacketCodec<RegistryByteBuf, StructureProtectionSyncPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.BOOL, StructureProtectionSyncPayload::inProtectedStructure,
            PacketCodecs.collection(HashSet::new, PacketCodecs.VAR_LONG), StructureProtectionSyncPayload::playerPlacedBlocks,
            OPTIONAL_BLOCK_TAG_CODEC, payload -> Optional.ofNullable(payload.protectedBlocksTag),
            OPTIONAL_BLOCK_TAG_CODEC, payload -> Optional.ofNullable(payload.breakableBlocksTag),
            (inProtected, placed, protectedOpt, breakableOpt) ->
                    new StructureProtectionSyncPayload(inProtected, placed, protectedOpt.orElse(null), breakableOpt.orElse(null))
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}