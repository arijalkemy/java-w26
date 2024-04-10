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

        // Iterar sobre las ciudades y actualizar las temperaturas máximas y mínimas
        for (int i = 0; i < ciudades.length; i++) {
            // Obtener las temperaturas actuales de la ciudad actual
            int temperaturaActualMax = temperaturas[i][1];
            int temperaturaActualMin = temperaturas[i][0];

            // Actualizar la temperatura máxima si es necesario y guardar el índice correspondiente
            if (temperaturaActualMax > temperaturaMaxima) {
                temperaturaMaxima = temperaturaActualMax;
                indiceTemperaturaMaxima = i;
            }

            // Actualizar la temperatura mínima si es necesario y guardar el índice correspondiente
            if (temperaturaActualMin < temperaturaMinima) {
                temperaturaMinima = temperaturaActualMin;
                indiceTemperaturaMinima = i;
            }
        }

        // Mostrar por pantalla la ciudad con temperatura mínima y su valor, así como el índice de la temperatura máxima y su valor
        System.out.println("Ciudad con temperatura mínima: " + ciudades[indiceTemperaturaMinima] + " " + temperaturaMinima + "\n" + "Indice temperatura máxima: " + ciudades[indiceTemperaturaMaxima] + " " + temperaturaMaxima);
    }

    }

