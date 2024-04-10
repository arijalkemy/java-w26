public class Main {
    public static void main(String[] args) {
        // Array de ciudades
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        // Array bidimensional de temperaturas, donde cada fila representa una ciudad y tiene dos valores: [temperatura mínima, temperatura máxima]
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        // Inicialización de variables para temperatura máxima, mínima e índices correspondientes
        int temperaturaMaxima = Integer.MIN_VALUE;
        int temperaturaMinima = Integer.MAX_VALUE;
        int indiceTemperaturaMaxima = 0;
        int indiceTemperaturaMinima = 0;

        // Se itera el array de ciudades y se setea la temperatura maxima y minima de cada indice del array bidimensional
        for (int i = 0; i < ciudades.length; i++) {
            // Obtener las temperaturas actuales de la ciudad actual
            int temperaturaActualMax = temperaturas[i][1];
            int temperaturaActualMin = temperaturas[i][0];

            // Se actualizan las variables de temperatura maxima si es necesario
            if (temperaturaActualMax > temperaturaMaxima) {
                temperaturaMaxima = temperaturaActualMax;
                indiceTemperaturaMaxima = i;
            }

            // Se actualizan las variables de temperatura maxima si es necesario
            if (temperaturaActualMin < temperaturaMinima) {
                temperaturaMinima = temperaturaActualMin;
                indiceTemperaturaMinima = i;
            }
        }

        // Se muestra por pantalla la ciudad con temperatura mínima y su valor, al igual que con la maxima
        System.out.println("Ciudad con temperatura mínima: " + ciudades[indiceTemperaturaMinima] + " " + temperaturaMinima + "\n" + "Indice temperatura máxima: " + ciudades[indiceTemperaturaMaxima] + " " + temperaturaMaxima);
    }

    }

