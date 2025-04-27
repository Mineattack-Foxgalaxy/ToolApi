package de.foxgalaxy.toolapi.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public interface ToolSettingsApplier {
    Item.Settings apply(Item.Settings settings, ToolMaterial material, float attackDamage, float attackSpeed);
}
