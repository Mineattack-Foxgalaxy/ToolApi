package de.foxgalaxy.toolapi;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ItemTable<M, T, I extends Info<M, T>> {
    private final Table<M, T, I> TABLE = HashBasedTable.create();

    private final Map<Identifier, I> ID_TO_INFO = new HashMap<>();

    public void add(I info) {
        TABLE.put(info.getMaterial(), info.getType(), info);
        ID_TO_INFO.put(Registries.ITEM.getId(info.getItem()), info);
    }

    public I getInfo(Identifier id) {
        return ID_TO_INFO.get(id);
    }

    public I getInfo(Item item) {
        return getInfo(Registries.ITEM.getId(item));
    }

    public Collection<M> getMaterials() {
        return TABLE.rowKeySet();
    }

    public Collection<T> getTypes() {
        return TABLE.columnKeySet();
    }

    public I getInfo(M material, T type) {
        return TABLE.get(material, type);
    }

    public Item getItem(M material, T type) {
        return getInfo(material, type).getItem();
    }

    public Map<T, I> getInfosForMaterial(M material) {
        return TABLE.row(material);
    }

    public Stream<Item> getItemsForMaterial(M material) {
        return getInfosForMaterial(material).values().stream().map(Info::getItem);
    }

    public Map<M, I> getInfosForType(T type) {
        return TABLE.column(type);
    }

    public Stream<Item> getItemsForType(T type) {
        return getInfosForType(type).values().stream().map(Info::getItem);
    }
}
