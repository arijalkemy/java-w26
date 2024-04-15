public class Main {
    public static void main(String[] args) {
        Ntwoseries serieDos = new Ntwoseries();
        //serieDos.initialValue((Integer)10);
        serieDos.initialValue(70);
        System.out.println(serieDos.nextNumber());
        serieDos.restartSeries();
        System.out.println(serieDos.nextNumber());
        System.out.println(serieDos.nextNumber());

        System.out.println("=========SERIES DE TRES ===========");

        Nthreeseries serieTres = new Nthreeseries();
        serieTres.initialValue(33);
        System.out.println(serieTres.nextNumber());
        System.out.println(serieTres.nextNumber());
        serieTres.restartSeries();
        System.out.println(serieTres.nextNumber());
    }
}
