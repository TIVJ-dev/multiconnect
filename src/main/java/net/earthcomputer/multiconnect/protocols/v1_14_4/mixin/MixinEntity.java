package net.earthcomputer.multiconnect.protocols.v1_14_4.mixin;

import net.earthcomputer.multiconnect.api.Protocols;
import net.earthcomputer.multiconnect.impl.ConnectionInfo;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class MixinEntity {

    @Shadow private double x;
    @Shadow private double z;

    @Shadow public abstract Box getBoundingBox();

    @Inject(method = "getVelocityAffectingPos", at = @At("HEAD"), cancellable = true)
    private void onGetVelocityAffectingPos(CallbackInfoReturnable<BlockPos> ci) {
        if (ConnectionInfo.protocolVersion <= Protocols.V1_14_4) {
            ci.setReturnValue(new BlockPos(x, getBoundingBox().y1 - 1, z));
        }
    }

}
