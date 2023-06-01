package ru.vidtu.illegalsinmyyard.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.vidtu.illegalsinmyyard.IIMY;

/**
 * Mixin for 2.x versions of Patchy.
 *
 * @author VidTu
 */
@Mixin(targets = "com.mojang.patchy.BlockedServers", remap = false)
@Pseudo
@SuppressWarnings({"MixinAnnotationTarget", "UnresolvedMixinReference"})
public final class BlockedServersNewMixin {
	private BlockedServersNewMixin() {
		throw new AssertionError("No instances.");
	}

	// For Patchy 2.0 and 2.1
	@Inject(method = "apply(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	public void illegalsinmyyard$apply$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "BlockedServers.apply(String)");
		cir.setReturnValue(false);
	}

	// For Patchy 2.2
	@Inject(method = "test(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	public void illegalsinmyyard$testString$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "BlockedServers.test(String)");
		cir.setReturnValue(false);
	}

	// For Patchy 2.2
	@Inject(method = "test(Ljava/lang/Object;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	public void illegalsinmyyard$testObject$return(Object server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "BlockedServers.test(Object)");
		cir.setReturnValue(false);
	}

	// For Patchy 2.x
	@Inject(method = "isBlockedServerHostName(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	public void illegalsinmyyard$isBlockedServerHostName$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "BlockedServers.isBlockedServerHostName(String)");
		cir.setReturnValue(false);
	}
}
