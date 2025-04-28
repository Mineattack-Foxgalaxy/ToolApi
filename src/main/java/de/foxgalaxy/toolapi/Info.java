package de.foxgalaxy.toolapi;

import net.minecraft.item.Item;

public class Info<M, T> {
    protected M material;
    protected T type;
    protected Item item;

    protected Info() {

    }

    public Info(M material, T type, Item item) {
        this.material = material;
        this.type = type;
        this.item = item;
    }

    public M getMaterial() {
        return material;
    }

    public T getType() {
        return type;
    }

    public Item getItem() {
        return item;
    }
}
