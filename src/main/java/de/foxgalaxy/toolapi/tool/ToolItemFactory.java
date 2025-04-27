package de.foxgalaxy.toolapi.tool;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public interface ToolItemFactory<T extends Item> {
    T create(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings);
}
