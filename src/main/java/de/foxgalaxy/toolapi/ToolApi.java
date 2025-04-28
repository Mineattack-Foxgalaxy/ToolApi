package de.foxgalaxy.toolapi;

import de.foxgalaxy.toolapi.armor.ArmorInfo;
import de.foxgalaxy.toolapi.armor.ArmorMaterialHelper;
import de.foxgalaxy.toolapi.tool.ToolMaterialHelper;
import de.foxgalaxy.toolapi.tool.ToolType;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

public class ToolApi implements ModInitializer {
    public static final ItemTable<ArmorMaterial, EquipmentType, ArmorInfo> ARMOR_TABLE = new ItemTable<>();

    @Override
    public void onInitialize() {
        RegistrationObserver.afterRegistration();
        ArmorMaterialHelper.register();
        ToolMaterialHelper.register();
        ToolType.register();
    }
}
