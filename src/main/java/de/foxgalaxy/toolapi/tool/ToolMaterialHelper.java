package de.foxgalaxy.toolapi.tool;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.util.Identifier;

public class ToolMaterialHelper {
    public static final RegistryKey<Registry<ToolMaterial>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.of("toolapi", "tool_material"));
    public static final Registry<ToolMaterial> REGISTRY = new SimpleRegistry<>(REGISTRY_KEY, Lifecycle.stable());

    public static final Codec<ToolMaterial> CODEC = REGISTRY.getCodec();

    public static void register() {
        Registry.register(REGISTRY, Identifier.of("minecraft", "wood"), ToolMaterial.WOOD);
        Registry.register(REGISTRY, Identifier.of("minecraft", "stone"), ToolMaterial.STONE);
        Registry.register(REGISTRY, Identifier.of("minecraft", "iron"), ToolMaterial.IRON);
        Registry.register(REGISTRY, Identifier.of("minecraft", "gold"), ToolMaterial.GOLD);
        Registry.register(REGISTRY, Identifier.of("minecraft", "diamond"), ToolMaterial.DIAMOND);
        Registry.register(REGISTRY, Identifier.of("minecraft", "netherite"), ToolMaterial.NETHERITE);
    }
}
