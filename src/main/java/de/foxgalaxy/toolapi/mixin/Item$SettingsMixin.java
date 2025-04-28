package de.foxgalaxy.toolapi.mixin;

import de.foxgalaxy.toolapi.armor.ArmorInfo;
import de.foxgalaxy.toolapi.tool.ToolInfo;
import de.foxgalaxy.toolapi.tool.ToolType;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.Settings.class)
public class Item$SettingsMixin {
    @Inject(method = "pickaxe", at = @At("HEAD"))
    private void onPickaxeSettings(ToolMaterial material, float attackDamage, float attackSpeed, CallbackInfoReturnable<Item.Settings> cir) {
        ToolInfo.onToolSettings((Item.Settings)(Object)this, material, ToolType.PICKAXE);
    }

    @Inject(method = "axe", at = @At("HEAD"))
    private void onAxeSettings(ToolMaterial material, float attackDamage, float attackSpeed, CallbackInfoReturnable<Item.Settings> cir) {
        ToolInfo.onToolSettings((Item.Settings)(Object)this, material, ToolType.AXE);
    }

    @Inject(method = "shovel", at = @At("HEAD"))
    private void onShovelSettings(ToolMaterial material, float attackDamage, float attackSpeed, CallbackInfoReturnable<Item.Settings> cir) {
        ToolInfo.onToolSettings((Item.Settings)(Object)this, material, ToolType.SHOVEL);
    }

    @Inject(method = "hoe", at = @At("HEAD"))
    private void onHoeSettings(ToolMaterial material, float attackDamage, float attackSpeed, CallbackInfoReturnable<Item.Settings> cir) {
        ToolInfo.onToolSettings((Item.Settings)(Object)this, material, ToolType.HOE);
    }

    @Inject(method = "sword", at = @At("HEAD"))
    private void onSwordSettings(ToolMaterial material, float attackDamage, float attackSpeed, CallbackInfoReturnable<Item.Settings> cir) {
        ToolInfo.onToolSettings((Item.Settings)(Object)this, material, ToolType.SWORD);
    }

    @Inject(method = "armor", at = @At("HEAD"))
    private void onArmorSettings(ArmorMaterial material, EquipmentType type, CallbackInfoReturnable<Item.Settings> cir) {
        ArmorInfo.onArmorSettings((Item.Settings)(Object)this, material, type);
    }
}
