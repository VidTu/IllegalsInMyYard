package ru.vidtu.illegalsinmyyard.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.vidtu.illegalsinmyyard.IIMY;

/**
 * Mixin for 1.2+ versions of Patchy.
 *
 * @author VidTu
 */
@Mixin(targets = "com.mojang.patchy.BlockedServers", remap = false)
@Pseudo
@SuppressWarnings({"MixinAnnotationTarget", "UnresolvedMixinReference"})
public final class BlockedServersOldMixin {
	private BlockedServersOldMixin() {
		throw new AssertionError("No instances.");
	}

	// For Patchy 1.2
	@Inject(method = "isBlockedServer(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	private static void illegalsinmyyard$isBlockedServer$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "BlockedServers.static.isBlockedServer(String)");
		cir.setReturnValue(false);
	}

	// For Patchy 1.2
	@Inject(method = "isBlockedServerHostName(Ljava/lang/String;)Z", at = @At("RETURN"), require = 0, cancellable = true)
	private static void illegalsinmyyard$isBlockedServerHostName$return(String server, CallbackInfoReturnable<Boolean> cir) {
		IIMY.onServerCheck(cir.getReturnValueZ(), server, "BlockedServers.static.isBlockedServerHostName(String)");
		cir.setReturnValue(false);
	}
}
