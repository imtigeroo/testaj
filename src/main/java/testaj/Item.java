package testaj;

import java.io.Serializable;

public class Item extends ItemData implements Serializable {

    public Item() {}

    public Item(Long data) {
        super(data);
    }

    @Override
    public String toString() {
        return String.format(
                "Item (id=%s, itemId=%s, quantity=%s, inventoryID=%s)", getId(), itemId, quantity, getInventoryID());
    }
}