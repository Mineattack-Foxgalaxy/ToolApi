package de.foxgalaxy.toolapi;

import de.foxgalaxy.toolapi.accessors.Item$SettingsAccessor;
import de.foxgalaxy.toolapi.armor.ArmorInfo;
import de.foxgalaxy.toolapi.tool.ToolInfo;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;

public class RegistrationObserver {
    public static void onItemCreate(Item item, Item.Settings settings) {
        ToolInfo.onItemCreate(item, settings);
        ArmorInfo.onItemCreate(item, settings);
    }

    public static void onItemRegister(RegistryKey<Item> registryKey, Item item) {

    }

    public static boolean isMinecraft(Item.Settings settings) {
        return ((Item$SettingsAccessor)settings).toolApi$getRegistryKey().getValue().getNamespace().equals("minecraft");
    }
}
