package bootcamp.bendezujonathan.imprimible.document;

import bootcamp.bendezujonathan.imprimible.Imprimible;

public abstract class Document implements Imprimible {
    
    private String path;

    Document(String path) {
        this.path = path;
    }

    public void showType() {
        System.out.printf(">> Imprimiendo tipo documento: %s, en la path: %s%n", getClass().getSimpleName(), path);
    }
}
