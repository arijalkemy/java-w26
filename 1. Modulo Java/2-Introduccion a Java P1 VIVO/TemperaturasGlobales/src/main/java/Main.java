public class Main {
        public static void main(String[] args) {
            // Array de cities
            String cities[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

            // Array bidimensional de temperatures, donde cada fila representa una ciudad y tiene dos valores: [temperatura mínima, temperatura máxima]
            int temperatures[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

            // Inicialización de variables para temperatura máxima, mínima e índices correspondientes
            int maxTemperature = Integer.MIN_VALUE;
            int minTemperature = Integer.MAX_VALUE;
            int indexMaxTemperature = 0;
            int indexMinTemperature = 0;

            // Se itera el array de cities y se setea la temperatura maxima y minima de cada indice del array bidimensional
            for (int i = 0; i < cities.length; i++) {
                // Obtener las temperatures actuales de la ciudad actual
                int currentMaxTemperature = temperatures[i][1];
                int currentMinTemperature = temperatures[i][0];

                // Se actualizan las variables de temperatura maxima si es necesario
                if (currentMaxTemperature > maxTemperature) {
                    maxTemperature = currentMaxTemperature;
                    indexMaxTemperature = i;
                }

                // Se actualizan las variables de temperatura maxima si es necesario
                if (currentMinTemperature < minTemperature) {
                    minTemperature = currentMinTemperature;
                    indexMinTemperature = i;
                }
            }

            // Se muestra por pantalla la ciudad con temperatura mínima y su valor, al igual que con la maxima
            System.out.println("Ciudad con temperatura mínima: " + cities[indexMinTemperature] + " " + minTemperature + "\n" + "Indice temperatura máxima: " + cities[indexMaxTemperature] + " " + maxTemperature);
        }

    }



