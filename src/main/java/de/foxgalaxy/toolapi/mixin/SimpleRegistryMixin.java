package de.foxgalaxy.toolapi.mixin;

import de.foxgalaxy.toolapi.RegistrationObserver;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SimpleRegistry.class)
public class SimpleRegistryMixin<T> {
    @Inject(method = "add", at = @At("HEAD"))
    private void onAdd(RegistryKey<T> key, T value, RegistryEntryInfo info, CallbackInfoReturnable<RegistryEntry.Reference<T>> cir) {
        if(this == Registries.ITEM) {
            RegistrationObserver.onItemRegister((RegistryKey<Item>) key, (Item) value);
        }
    }
}
