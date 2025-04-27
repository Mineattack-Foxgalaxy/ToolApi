package de.foxgalaxy.toolapi;

import de.foxgalaxy.toolapi.armor.ArmorInfo;
import de.foxgalaxy.toolapi.tool.ToolInfo;
import de.foxgalaxy.toolapi.tool.ToolType;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

import java.util.IdentityHashMap;
import java.util.Map;

public class RegistrationObserver {
    private static final Map<Item.Settings, ToolPreInfo> PRE_TOOLS = new IdentityHashMap<>();
    private static final Map<Item.Settings, ArmorPreInfo> PRE_ARMOR = new IdentityHashMap<>();

    public static void onToolSettings(Item.Settings settings, ToolMaterial material, ToolType type) {
        ToolPreInfo pre = new ToolPreInfo();
        pre.material = material;
        pre.type = type;
        PRE_TOOLS.put(settings, pre);
    }

    public static void onArmorSettings(Item.Settings settings, ArmorMaterial material, EquipmentType type) {
        ArmorPreInfo pre = new ArmorPreInfo();
        pre.material = material;
        pre.type = type;
        PRE_ARMOR.put(settings, pre);
    }

    public static void onItemCreate(Item item, Item.Settings settings) {
        if(PRE_TOOLS.containsKey(settings)) {
            ToolPreInfo preInfo = PRE_TOOLS.get(settings);
            preInfo.toolItem = item;
        } else if(PRE_ARMOR.containsKey(settings)) {
            ArmorPreInfo preInfo = PRE_ARMOR.get(settings);
            preInfo.armorItem = item;
        }
    }

    public static void afterRegistration() {
        for(ToolPreInfo pre : PRE_TOOLS.values()) {
            ToolApi.TOOL_TABLE.add(pre.createToolInfo());
        }

        for(ArmorPreInfo pre : PRE_ARMOR.values()) {
            ToolApi.ARMOR_TABLE.add(pre.createArmorInfo());
        }
    }

    private static class ToolPreInfo {
        Item toolItem;
        ToolMaterial material;
        ToolType type;

        ToolInfo createToolInfo() {
            return new ToolInfo(material, type, toolItem);
        }
    }

    private static class ArmorPreInfo {
        Item armorItem;
        ArmorMaterial material;
        EquipmentType type;

        ArmorInfo createArmorInfo() {
            return new ArmorInfo(material, type, armorItem);
        }
    }
}
