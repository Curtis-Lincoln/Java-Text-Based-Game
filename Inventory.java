public class Inventory{
    final int MAX_ITEMS = 10;
    String[] inventory = new String[MAX_ITEMS];

    public Inventory(){
    }

    public void addItem(String item){
        boolean full = true;
        for(int i = 0; i < MAX_ITEMS; i++){
            if(inventory[i] == null){
                full = false;
                inventory[i] = item;
                break;
            }
        }
        if(full){
            System.out.println("Inventory is full.");
        }
    }

    public int hasItem(String item){
        for(int i = 0; i < MAX_ITEMS; i++){
            if(item.equals(inventory[i])){
                return i;
            }
        }
        return -1;
    }

    public void removeItem(String item){
        String[] newInventory = new String[MAX_ITEMS];
        int newInventoryIndex = 0;
        for(int i = 0; i < MAX_ITEMS; i++){
            if(inventory[i] != item){
                newInventory[newInventoryIndex] = inventory[i];
                newInventoryIndex++;
            }
        } 
        inventory = newInventory;
    }

    public String displayInventory(){
        String output = "";
        for(int i = 0; i < MAX_ITEMS; i++){
            if(inventory[i] == null){
                break;
            }
            output = output + inventory[i] + " ";
        }
        return output;
    }
}
    

