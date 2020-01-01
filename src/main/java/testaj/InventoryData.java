package testaj;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.ArrayList;
import java.util.List;

@Table("inventories")
public class InventoryData extends Model {

    private Integer id;
    private int type;
    private short slots;
    private List<Item> items;

    private InventoryData data;

    public InventoryData() {}

    public InventoryData(Integer tableID) {
        this.data = findById(tableID);

        this.id = data.getInteger("id");
        this.type = data.getInteger("type");
        this.slots = data.getInteger("slots").shortValue();
        items = new ArrayList<>();

        List<ItemData> itemData = ItemData.where("inventoryid = ?", id);
        for (ItemData item : itemData) {
            items.add(new Item(item.getLong("id")));
        }

    }

    public static Inventory load(Integer id) {
        return new Inventory(id);
    }

    public void update() {
        if (data != null) {
            data.setId(getId());
            data.saveIt();
        }
        for (Item item : items) {
            item.update();
        }
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // other set/gets omitted for brevity

    @Override
    public String toString() {
        return String.format(
                "InventoryData (id=%s, type=%s, slots=%s, items=%s)", id, type, slots, items);
    }
}
