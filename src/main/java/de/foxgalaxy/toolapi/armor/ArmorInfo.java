package de.foxgalaxy.toolapi.armor;

import de.foxgalaxy.toolapi.Info;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

public class ArmorInfo extends Info<ArmorMaterial, EquipmentType> {
    public ArmorInfo(ArmorMaterial material, EquipmentType type, Item item) {
        super(material, type, item);
    }
}
