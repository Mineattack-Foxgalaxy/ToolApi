package de.foxgalaxy.toolapi.tool;

import de.foxgalaxy.toolapi.Info;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;

public class ToolInfo extends Info<ToolMaterial, ToolType> {
    public ToolInfo(ToolMaterial material, ToolType type, Item item) {
        super(material, type, item);
    }
}
