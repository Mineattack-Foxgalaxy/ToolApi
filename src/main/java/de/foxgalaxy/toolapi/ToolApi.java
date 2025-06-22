package de.foxgalaxy.toolapi;

import de.foxgalaxy.toolapi.armor.ArmorMaterialHelper;
import de.foxgalaxy.toolapi.tool.ToolMaterialHelper;
import de.foxgalaxy.toolapi.tool.ToolType;
import net.fabricmc.api.ModInitializer;

public class ToolApi implements ModInitializer {
    @Override
    public void onInitialize() {
        ArmorMaterialHelper.register();
        ToolMaterialHelper.register();
        ToolType.register();
    }
}
