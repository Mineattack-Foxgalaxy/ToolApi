package de.foxgalaxy.toolapi.mixin;

import de.foxgalaxy.toolapi.RegistrationObserver;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void onConstructItem(Item.Settings settings, CallbackInfo ci) {
        RegistrationObserver.onItemCreate((Item)(Object)this, settings);
    }
}
