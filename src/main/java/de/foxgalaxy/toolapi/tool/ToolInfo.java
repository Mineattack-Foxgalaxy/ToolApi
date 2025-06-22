package de.foxgalaxy.toolapi.tool;

import de.foxgalaxy.toolapi.Info;
import de.foxgalaxy.toolapi.ItemTable;
import de.foxgalaxy.toolapi.RegistrationObserver;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import org.jetbrains.annotations.ApiStatus;

import java.util.IdentityHashMap;
import java.util.Map;

public class ToolInfo extends Info<ToolMaterial, ToolType<?>> {
    private static final Map<Item.Settings, ToolInfo> PRE_TOOLS = new IdentityHashMap<>();
    public static final ItemTable<ToolMaterial, ToolType<?>, ToolInfo> TOOL_TABLE = new ItemTable<>();

    float attackDamage;
    float attackSpeed;

    private ToolInfo() {
        super();
    }


    public ToolInfo(ToolMaterial material, ToolType<?> type, Item item, float attackDamage, float attackSpeed) {
        super(material, type, item);
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    @ApiStatus.Internal
    public static void onToolSettings(Item.Settings settings, ToolMaterial material, ToolType<?> type, float attackDamage, float attackSpeed) {
        ToolInfo pre = new ToolInfo();
        pre.material = material;
        pre.type = type;
        pre.attackDamage = attackDamage;
        pre.attackSpeed = attackSpeed;
        PRE_TOOLS.put(settings, pre);
    }

    @ApiStatus.Internal
    public static void onItemCreate(Item item, Item.Settings settings) {
        if(PRE_TOOLS.containsKey(settings)) {
            if(RegistrationObserver.isMinecraft(settings)) {
                ToolInfo preInfo = PRE_TOOLS.get(settings);
                preInfo.item = item;

                afterRegistration(preInfo, settings);
            } else {
                PRE_TOOLS.remove(settings);
            }
        }
    }

    public static void onItemRegister(RegistryKey<Item> registryKey, Item item) {

    }

    public static void afterRegistration(ToolInfo preInfo, Item.Settings settings) {
        TOOL_TABLE.add(preInfo);
        PRE_TOOLS.remove(settings);
    }
}
