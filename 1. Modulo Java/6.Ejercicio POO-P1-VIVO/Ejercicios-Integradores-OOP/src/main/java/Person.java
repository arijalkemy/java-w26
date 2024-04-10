public class Person {

    private String name;
    private int age;
    private String idNumber;
    private double weigth;
    private double height;

    // Constructor Methods
    public Person() {

    }

    public Person(String name, int age, String idNumber) {
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
    }

    public Person(String name, int age, String idNumber, double weigth, double height){
        this.name = name;
        this.age = age;
        this.idNumber = idNumber;
        this.weigth = weigth;
        this.height = height;
    }

    // Methods
    public int calculateIMC(double weigth, double height){
        double valueOfIMC = (weigth/Math.pow(height, 2));
        int result = 0;

        if (valueOfIMC < 20) result = -1;
        else if ((valueOfIMC >= 20) && (valueOfIMC <= 25)) result = 0;
        else result = 0;

        return result;
    }

    public boolean isAdult(int age){
        return (age < 18) ? false: true;
    }

    public static void printPersonInfo(Person person){
        System.out.println("-------------------------------------------" + "\n" +
                           "La información de la persona es la siguiente:" + "\n" +
                           "Nombre: " + person.getName() + "\n" +
                           "Edad: " + person.getAge()  + "\n" +
                           "DNI: " + person.getIdNumber() + "\n" +
                           "Peso: " + person.getWeigth() + "\n" +
                           "Altura: " + person.getHeight() + "\n" +
                           "-------------------------------------------"   
                           );
    }

    public static void printIMCAge(Person person){
        int imcValue = person.calculateIMC(person.getWeigth(), person.getHeight());
        String weighLevel = "";
        String adultValue = (person.isAdult(person.getAge())) ? "Es mayor de edad" : "Es menor de edad";

        
        if (imcValue == -1 ) weighLevel = "Bajo de peso";
        else if (imcValue == 0) weighLevel = "Peso saludable";
        else weighLevel = "Sobrepeso";

        System.out.println("-------------------------------------------" + "\n" +
                           "El índice de masa corporal de " + person.getName() + " es:"+ "\n" +
                           "Valor IMC: " + imcValue + " - " + weighLevel + "\n" +
                           "Estado de edad: " + adultValue + "\n" +
                           "-------------------------------------------"
        );
    }

    // Getters and Setters
    public void setAge(int age) {
        try {
            if (age>0) this.age = age;
            else throw new IllegalArgumentException("El valor de la edad ingresada no es correcto.");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }   
    }
    public int getAge() {return age;}
    
    public void setHeight(double height) {
        try {
            if (height>0) this.height = height;
            else throw new IllegalArgumentException("El valor de la altura ingresada no es correcto.");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } 
    }

    public double getHeight() {return height;}

    public void setWeigth(double weigth) {
        try {
            if (weigth>0) this.weigth = weigth;
            else throw new IllegalArgumentException("El valor del peso ingresado no es correcto.");
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        } 
    }
    
    public double getWeigth() {return weigth;}

    public void setIdNumber(String idNumber) {this.idNumber = idNumber;}
    public String getIdNumber() {return idNumber;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}


}
