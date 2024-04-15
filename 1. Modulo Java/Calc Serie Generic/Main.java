public class Main {
    public static void main(String[] args) {
        System.out.println("##### 2 #####");

        Serie<Integer> s2 = new SerieTwo(1);
        s2.next();
        s2.next();
        s2.resetSerie();

        System.out.println("##### 3 #####");
        Serie<Double> s3 = new SerieThree(0D);
        s3.next();
        s3.next();
        s3.resetSerie();
        s3.next();

        System.out.println("##### 6 #####");
        Serie<Long> s6 = new SerieGeneral(6, 11L);
        s6.next();
        s6.next();
        s6.next();
        s6.resetSerie();
        s6.next();
    }
}
