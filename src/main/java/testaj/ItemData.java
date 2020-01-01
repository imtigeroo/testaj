package testaj;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

@Table("items")
public class ItemData extends Model {
    protected int itemId;
    protected int quantity;
    private Long id;
    private Integer inventoryID;
    private ItemData data;

    public ItemData() {
    }

    public ItemData(Long id) {
        this.data = findById(id);
        this.id = data.getLong("id");
        this.inventoryID = data.getInteger("inventoryid");
        this.itemId = data.getInteger("itemid");
        this.quantity = data.getInteger("quantity");
    }

    public void update() {
        if (data != null) {
            data.setId(getId());
            data.saveIt();
        }
    }

    @Override
    public Long getId() {
        return id;
    }

    public Integer getInventoryID() {
        return inventoryID;
    }

    // other set/gets omitted for brevity
}