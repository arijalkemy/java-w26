public class Cliente {
    private String name;
    private String adress;
    private int id;

    public Cliente(String name,String adress,int id){
        this.name = name;
        this.adress = adress;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setId(int id) {
        this.id = id;
    }
}
