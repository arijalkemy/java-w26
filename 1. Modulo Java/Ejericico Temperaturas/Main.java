public class Main {
    public static void main(String[] args) {
        String cities[] = { "Londres", "Madrid", "New York", "Buenos Aires", "Asuncion", "Sao Pablo", "Lima",
                "Santiago de Chile", "Lisboa", "Tokio" };
        Integer temperatures[][] = {
                { -2, 33 },
                { -3, 32 },
                { -8, 27 },
                { 4, 37 },
                { 6, 42 },
                { 5, 43 },
                { 0, 39 },
                { -7, 26 },
                { -1, 31 },
                { -10, 35 }
        };
        int i_min = Integer.MAX_VALUE, i_max = Integer.MIN_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i][0] <= i_min)
                i_min = i;
            if (temperatures[i][0] >= i_max)
                i_max = i;
        }
        System.out.println("Min temp " + temperatures[i_min][0] + " - City " + cities[i_min]);
        System.out.println("Max temp " + temperatures[i_max][1] + " - City " + cities[i_max]);
    }
}