package testaj;

public class Test {

    public static void main(String[] args) {
        Database.get().init();
        Database.get().openCon();

        InventoryData inventory = new InventoryData(1);

        if (inventory != null) {
            System.out.println(inventory.toString());
        }

        Database.get().close();
    }
}
