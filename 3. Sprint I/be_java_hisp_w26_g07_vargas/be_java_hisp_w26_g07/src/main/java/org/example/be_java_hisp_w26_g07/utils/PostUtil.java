package org.example.be_java_hisp_w26_g07.utils;

import java.util.Arrays;
import java.util.List;

public class PostUtil {
    private static int counter = 11;

    public static List<String> colores = Arrays.asList(
            "blanco", "negro", "rojo", "azul", "verde", "amarillo", "naranja",
            "morado", "rosa", "gris", "cyan", "magenta", "turquesa", "beige",
            "marfil", "marrón", "dorado", "plateado", "oro", "platino", "índigo",
            "coral", "ocre", "cian", "cobre", "púrpura", "lavanda", "rubí",
            "zafiro", "esmeralda", "ámbar", "amaranto", "carmesí", "carmín",
            "añil", "ciruela", "lima", "lila", "limón", "malva", "mostaza",
            "salmón", "sepia", "terracota", "violeta", "borgoña", "burdeos",
            "caoba", "caqui", "carmesí", "white", "black", "red", "blue", "green",
            "purple", "pink", "gray", "cyan", "magenta", "turquoise", "beige",
            "ivory", "brown", "gold", "silver", "gold", "platinum", "indigo",
            "coral", "ochre", "cyan", "copper", "purple", "lavender", "ruby",
            "sapphire", "emerald", "amber", "amaranth", "crimson", "carmine",
            "indigo", "plum", "lime", "lilac", "lemon", "mauve", "mustard",
            "salmon", "sepia", "terracotta", "violet", "burgundy", "bordeaux",
            "mahogany", "khaki", "crimson", "yellow", "orange"
    );

    public static Double convertToDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static int increaseCounter() {
        return counter++;
    }
}
