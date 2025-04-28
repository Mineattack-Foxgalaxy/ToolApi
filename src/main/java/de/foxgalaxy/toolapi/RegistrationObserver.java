package de.foxgalaxy.toolapi;

import de.foxgalaxy.toolapi.armor.ArmorInfo;
import de.foxgalaxy.toolapi.tool.ToolInfo;
import net.minecraft.item.Item;

public class RegistrationObserver {
    public static void onItemCreate(Item item, Item.Settings settings) {
        ToolInfo.onItemCreate(item, settings);
        ArmorInfo.onItemCreate(item, settings);
    }

    public static void afterRegistration() {
        ToolInfo.afterRegistration();
        ArmorInfo.afterRegistration();
    }
}
