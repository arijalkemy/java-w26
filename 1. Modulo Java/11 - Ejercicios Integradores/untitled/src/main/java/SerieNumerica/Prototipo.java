package SerieNumerica;

public abstract class Prototipo{

    protected Number valorInicial;
    protected Number serie;
    protected int contador;

    public Prototipo(Number serie) {
        this.serie = serie;
        this.contador = 1;
        this.valorInicial = 0;
    }

    public Number siguiente(){
        return null;
    };

    public void reiniciarSerie(){
        this.contador = 1;
    };

    public void valorInicial( Number valor ){
        this.valorInicial = valor;
        reiniciarSerie();
    };

    public void imprimirSerie(int n ){

        for( int i = 0; i < n; i++){
            System.out.println(this.siguiente());
        }
    }
}
