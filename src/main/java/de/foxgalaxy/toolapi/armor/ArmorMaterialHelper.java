package de.foxgalaxy.toolapi.armor;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.util.Identifier;

public class ArmorMaterialHelper {
    public static final RegistryKey<Registry<ArmorMaterial>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.of("toolapi", "armor_material"));
    public static final Registry<ArmorMaterial> REGISTRY = new SimpleRegistry<>(REGISTRY_KEY, Lifecycle.stable());

    public static final Codec<ArmorMaterial> CODEC = REGISTRY.getCodec();

    static {
        Registry.register(REGISTRY, Identifier.of("minecraft", "leather"), ArmorMaterials.LEATHER);
        Registry.register(REGISTRY, Identifier.of("minecraft", "chain"), ArmorMaterials.CHAIN);
        Registry.register(REGISTRY, Identifier.of("minecraft", "iron"), ArmorMaterials.IRON);
        Registry.register(REGISTRY, Identifier.of("minecraft", "gold"), ArmorMaterials.GOLD);
        Registry.register(REGISTRY, Identifier.of("minecraft", "diamond"), ArmorMaterials.DIAMOND);
        Registry.register(REGISTRY, Identifier.of("minecraft", "netherite"), ArmorMaterials.NETHERITE);
        Registry.register(REGISTRY, Identifier.of("minecraft", "turtle_scute"), ArmorMaterials.TURTLE_SCUTE);
        Registry.register(REGISTRY, Identifier.of("minecraft", "armadillo_scute"), ArmorMaterials.ARMADILLO_SCUTE);
    }

    public static void register() {

    }
}
