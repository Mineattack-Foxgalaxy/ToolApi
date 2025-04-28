package de.foxgalaxy.toolapi.tool;

import de.foxgalaxy.toolapi.Info;
import de.foxgalaxy.toolapi.ItemTable;
import de.foxgalaxy.toolapi.ToolApi;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
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
    public static void onToolSettings(Item.Settings settings, ToolMaterial material, ToolType<?> type) {
        ToolInfo pre = new ToolInfo();
        pre.material = material;
        pre.type = type;
        PRE_TOOLS.put(settings, pre);
    }

    @ApiStatus.Internal
    public static void onItemCreate(Item item, Item.Settings settings) {
        if(PRE_TOOLS.containsKey(settings)) {
            ToolInfo preInfo = PRE_TOOLS.get(settings);
            preInfo.item = item;
        }
    }

    public static void afterRegistration() {
        for(ToolInfo pre : PRE_TOOLS.values()) {
            TOOL_TABLE.add(pre);
        }
        PRE_TOOLS.clear();
    }
}
