package org.example;

public class Record {
    private Category userCategory;
    private int recordId;
    private static int nextId = 0;
    private int quantity;
    private Player player;
    private boolean isRegistered;
    public Record(Player player, Category userCategory, int quantity) {
        this.player = player;
        this.userCategory = userCategory;
        this.recordId = nextId += 1;
        this.quantity = quantity;
        this.isRegistered = true;
    }
    public void printRecordInfo(){
        System.out.println("Categoria: " + this.userCategory.getName() + "ID Ticket: " + this.recordId + "\n" + "Nombre del corredor: " + this.player.getFirstName() + " "+ this.player.getLastName() + "\n" + "Edad: " + this.player.getAge() + "\n" + "Cantidad: " + this.quantity);
    }
    public boolean isRegistered() {
        return this.isRegistered;
    }

    public int getRecordId() {
        return this.recordId;
    }

    public Category getUserCategory() {
        return this.userCategory;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
