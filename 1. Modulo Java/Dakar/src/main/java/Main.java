public class Main {
    public static void main(String[] args) {

        SocorristaAuto socorrista = new SocorristaAuto(1000000,23,24,"ABS");
        SocorristaMoto socorrista2 = new SocorristaMoto(20000,24,20,"BSC");


        Carrera carreraUno = new Carrera(1234,1000,
                "Carrera",5,socorrista,socorrista2);

        carreraUno.darDeAltaAuto(1000000,23,24,"AAA");
        carreraUno.darDeAltaAuto(123123,23,24,"BBB");
        carreraUno.darDeAltaAuto(1,23,24,"CCC");
        carreraUno.darDeAltaAuto(4444,23,24,"DDD");
        carreraUno.darDeAltaAuto(3333,23,24,"FFF");
        carreraUno.darDeAltaMoto(3333,23,24,"ggg");

        System.out.println(carreraUno.obtenerGanador());

        carreraUno.socorrerAuto("AAA");
        //carreraUno.socorrerMoto("ggg");


    }
}
