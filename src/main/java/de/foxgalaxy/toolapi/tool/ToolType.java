package de.foxgalaxy.toolapi.tool;

import com.mojang.serialization.Lifecycle;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public interface ToolType<T extends Item> {
    RegistryKey<Registry<ToolType<?>>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.of("toolapi", "tool_type"));
    Registry<ToolType<?>> REGISTRY = new SimpleRegistry<>(REGISTRY_KEY, Lifecycle.stable());

    MiningToolType<Item> PICKAXE = Registry.register(REGISTRY, Identifier.ofVanilla("pickaxe"), new MiningToolType<>(
            BlockTags.PICKAXE_MINEABLE,
            0.0F,
            Item.Settings::pickaxe,
            Item.class,
            null
    ));

    MiningToolType<AxeItem> AXE = Registry.register(REGISTRY, Identifier.ofVanilla("axe"), new MiningToolType<>(
            BlockTags.AXE_MINEABLE,
            5.0F,
            Item.Settings::axe,
            AxeItem.class,
            AxeItem::new
    ));

    MiningToolType<HoeItem> HOE = Registry.register(REGISTRY, Identifier.ofVanilla("hoe"), new MiningToolType<>(
            BlockTags.HOE_MINEABLE,
            0.0F,
            Item.Settings::hoe,
            HoeItem.class,
            HoeItem::new
    ));

    MiningToolType<ShovelItem> SHOVEL = Registry.register(REGISTRY, Identifier.ofVanilla("shovel"), new MiningToolType<>(
            BlockTags.SHOVEL_MINEABLE,
            0.0F,
            Item.Settings::shovel,
            ShovelItem.class,
            ShovelItem::new
    ));

    SwordToolType<Item> SWORD = Registry.register(REGISTRY, Identifier.ofVanilla("sword"), new SwordToolType<>(
            Item.Settings::sword,
            Item.class,
            null
    ));

    Class<T> toolItemClass();

    ToolSettingsApplier toolSettingsApplier();

    @Nullable
    ToolItemFactory<T> toolItemFactory();


    static void register() {

    }

    record MiningToolType<T extends Item>(
            TagKey<Block> mineableTag,
            float disableBlockingForSeconds,
            ToolSettingsApplier toolSettingsApplier,
            Class<T> toolItemClass,
            ToolItemFactory<T> toolItemFactory
    ) implements ToolType<T> {}

    record SwordToolType<T extends Item>(
            ToolSettingsApplier toolSettingsApplier,
            Class<T> toolItemClass,
            ToolItemFactory<T> toolItemFactory
    ) implements ToolType<T> {}
}
