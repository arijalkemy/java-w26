package org.example.CarreraDeLaSelva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Category categorySmall = new Category(1, "small", "2 km por selva y arroyos.", 2);
        Category categoryMedium = new Category(2, "medium", "5 km por selva, arroyos y barro", 5);
        Category categoryAdvanced = new Category(3, "advanced", "10 km por selva, arroyos, barro y escalada en piedra", 10);

        List<String> names = Arrays.asList("Juan", "María", "Carlos", "Laura", "Pedro", "Ana", "Diego", "Sofía", "Luis", "Elena");

        List<Category> categoryList = Arrays.asList(categorySmall, categoryMedium, categoryAdvanced);

        Random rand = new Random();

        List<Competitor> competitorList = new ArrayList<>();

        names.forEach((e) -> {
            int randomCategory = rand.nextInt(3);
            int age = rand.nextInt(30) +5;
            int idCompetitor = rand.nextInt(99999);
            Category category = categoryList.get(randomCategory);
            Competitor newCompetitor = new Competitor(idCompetitor, e, age, category);
            competitorList.add(newCompetitor);
        });

        List<Inscription> inscriptionList = new ArrayList<>();

        competitorList.forEach((competitor -> {
            int idInscription = rand.nextInt(99999);
            Inscription inscription = new Inscription(idInscription, competitor.getCategory(), competitor);
            inscriptionList.add(inscription);
        }));

        viewList(inscriptionList);

        List<Inscription> onlyMediumCategory = inscriptionList.stream().filter((e) -> e.getCategory().equals(categoryMedium)).collect(Collectors.toList());
        viewList(onlyMediumCategory);


    }

    public static void viewList(List<Inscription> list){
        System.out.println("+++++++++++++");
        list.forEach((e) -> {
            System.out.println(e);
        });
        System.out.println("+++++++++++++");
    }
}