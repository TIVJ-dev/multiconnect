package net.earthcomputer.multiconnect.protocols.v1_13_2.mixin;

import net.minecraft.client.network.packet.LightUpdateS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(LightUpdateS2CPacket.class)
public interface LightUpdatePacketAccessor {

    @Accessor
    void setChunkX(int chunkX);

    @Accessor
    void setChunkZ(int chunkZ);

    @Accessor
    void setSkylightMask(int skylightMask);

    @Accessor
    void setBlocklightMask(int blocklightMask);

    @Accessor
    void setBlockLightUpdates(List<byte[]> blockLightUpdates);

    @Accessor
    void setSkyLightUpdates(List<byte[]> skyLightUpdates);
}
