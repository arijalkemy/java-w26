public class Main {

    public static void main(String[] args) {
        
        Person personEmpty = new Person();
        Person personBasic = new Person("Salomé", 24, "1000591649");
        Person personFull = new Person("Andrés", 22, "1007101414", 73.0, 1.77);
        
        // Person personTest = new Person("Andrés"); ? --> No se puede ya que Person(String nombre) es un constructor que no está definido

        Person.printPersonInfo(personFull);
        Person.printIMCAge(personFull);



    }   
    
}
