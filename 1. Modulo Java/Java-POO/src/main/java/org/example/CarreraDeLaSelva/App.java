package org.example.CarreraDeLaSelva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {

    static List<Inscription> inscriptionList = new ArrayList<>();

    static List<String> names = Arrays.asList("Juan", "María", "Carlos", "Laura", "Pedro", "Ana", "Diego", "Sofía", "Luis", "Elena");

    static List<Competitor> competitorList = new ArrayList<>();

    public static void viewList(String nameList, List<Inscription> list) {
        System.out.println("++++++++++++++++++" + nameList + "++++++++++++++++++++");
        list.forEach((e) -> {
            System.out.println(e);
        });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public static List<Inscription> inscriptionsByCategory(Category category) {
        return inscriptionList.stream().filter((e) -> e.getCategory().equals(category)).collect(Collectors.toList());
    }

    public static void loadCompetitorList(List<Category> categoryList) {
        Random rand = new Random();
        names.forEach((e) -> {
            int randomCategory = rand.nextInt(3);
            int age = rand.nextInt(30) + 5;
            int idCompetitor = rand.nextInt(99999);
            Category category = categoryList.get(randomCategory);
            Competitor newCompetitor = new Competitor(idCompetitor, e, age, category);
            competitorList.add(newCompetitor);
        });
    }

    public static void loadInscriptionsList() {
        Random rand = new Random();
        competitorList.forEach((competitor -> {
            int idInscription = rand.nextInt(99999);
            Inscription inscription = new Inscription(idInscription, competitor.getCategory(), competitor);
            inscriptionList.add(inscription);
        }));
    }

    public static Competitor deregistered() {
        Random rand = new Random();
        int randIndex = rand.nextInt(9);
        Competitor deregistered = inscriptionList.get(randIndex).getCompetitor();
        inscriptionList.remove(randIndex);
        return deregistered;
    }

    public static int calculateMountTotal (List<Inscription> inscriptionList) {
       return inscriptionList.stream().mapToInt(Inscription::getMount).reduce(0,Integer::sum);
    }

    public static void main(String[] args) {

        Category categorySmall = new Category(1, "small", "2 km por selva y arroyos.", 2);
        Category categoryMedium = new Category(2, "medium", "5 km por selva, arroyos y barro", 5);
        Category categoryAdvanced = new Category(3, "advanced", "10 km por selva, arroyos, barro y escalada en piedra", 10);


        List<Category> categoryList = Arrays.asList(categorySmall, categoryMedium, categoryAdvanced);

        loadCompetitorList(categoryList);

        loadInscriptionsList();

        viewList("Full Inscriptions", inscriptionList);

        viewList("Category small", inscriptionsByCategory(categorySmall));
        viewList("Category Medium", inscriptionsByCategory(categoryMedium));
        viewList("Category Advanced", inscriptionsByCategory(categoryAdvanced));


        Competitor competitorDeregistered = deregistered();
        System.out.println("Competitor deregistered: " + competitorDeregistered);

        viewList("Category with competitor deregitered", inscriptionsByCategory(competitorDeregistered.getCategory()));


        System.out.println("Mount total: " + calculateMountTotal(inscriptionList));
        System.out.println("Mount total by Category Small: " + calculateMountTotal(inscriptionsByCategory(categorySmall)));
        System.out.println("Mount total by Category Medium: " + calculateMountTotal(inscriptionsByCategory(categoryMedium)));
        System.out.println("Mount total by Category Advanced: " + calculateMountTotal(inscriptionsByCategory(categoryAdvanced)));

    }


}