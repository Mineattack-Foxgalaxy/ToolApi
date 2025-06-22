package de.foxgalaxy.toolapi.armor;

import de.foxgalaxy.toolapi.Info;
import de.foxgalaxy.toolapi.ItemTable;
import de.foxgalaxy.toolapi.RegistrationObserver;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;

import java.util.IdentityHashMap;
import java.util.Map;

public class ArmorInfo extends Info<ArmorMaterial, EquipmentType> {
    public static final ItemTable<ArmorMaterial, EquipmentType, ArmorInfo> ARMOR_TABLE = new ItemTable<>();

    private static final Map<Item.Settings, ArmorInfo> PRE_ARMOR = new IdentityHashMap<>();

    public ArmorInfo() {
        super();
    }

    public ArmorInfo(ArmorMaterial material, EquipmentType type, Item item) {
        super(material, type, item);
    }

    public static void onArmorSettings(Item.Settings settings, ArmorMaterial material, EquipmentType type) {
        ArmorInfo pre = new ArmorInfo();
        pre.material = material;
        pre.type = type;
        PRE_ARMOR.put(settings, pre);
    }

    public static void onItemCreate(Item item, Item.Settings settings) {
        if(PRE_ARMOR.containsKey(settings)) {
            if(RegistrationObserver.isMinecraft(settings)) {
                ArmorInfo preInfo = PRE_ARMOR.get(settings);
                preInfo.item = item;

                afterRegistration(preInfo, settings);
            } else {
                PRE_ARMOR.remove(settings);
            }
        }
    }

    public static void afterRegistration(ArmorInfo preInfo, Item.Settings settings) {
        ARMOR_TABLE.add(preInfo);
        PRE_ARMOR.remove(settings);
    }
}
