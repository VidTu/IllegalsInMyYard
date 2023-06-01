package ru.vidtu.illegalsinmyyard.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.vidtu.illegalsinmyyard.IIMY;

/**
 * Mixin for 1.0 and 1.1 versions of Patchy.
 *
 * @author VidTu
 */
@Mixin(targets = "io.netty.bootstrap.Bootstrap", remap = false)
@Pseudo
@SuppressWarnings({"MixinAnnotationTarget", "UnresolvedMixinReference"})
public final class BootstrapMixin {
	private BootstrapMixin() {
		throw new AssertionError("No instances.");
	}

	@Inject(method = "isBlockedServer(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	public void illegalsinmyyard$isBlockedServer$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "Bootstrap.isBlockedServer(String)");
		cir.setReturnValue(false);
	}

	@Inject(method = "isBlockedServerHostName(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	public void illegalsinmyyard$isBlockedServerHostName$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "Bootstrap.isBlockedServerHostName(String)");
		cir.setReturnValue(false);
	}
}
