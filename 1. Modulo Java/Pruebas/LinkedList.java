public class LinkedList {
    List<String> listaPersonas = new LinkedList<String>();

    public LinkedList()
    {
        listaPersonas.add("CR7");
        listaPersonas.add(0,"Cristiano Ronaldo");

        listaPersonas.size();

        for(String nombre : listaPersonas)
        {
            System.out.println(nombre);
        }
    }

}
