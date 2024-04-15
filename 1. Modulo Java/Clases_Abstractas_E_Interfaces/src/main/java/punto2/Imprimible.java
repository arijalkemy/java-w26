package punto2;

//Creación de la interfaz Imprimible, tener en cuenta que:
/*Las interfaces en Java tradicionalmente solo podían tener métodos abstractos,
es decir, métodos sin implementación.
Sin embargo, desde Java 8, las interfaces pueden tener métodos con implementación
a través de métodos por defecto (default) y métodos estáticos.

Métodos abstractos: Son los métodos que no tienen cuerpo y deben ser implementados
por las clases que implementan la interfaz.

Métodos por defecto (Default methods): Son métodos dentro de una interfaz que
tienen una implementación por defecto. Las clases que implementan la interfaz
pueden sobrescribir estos métodos, pero no están obligadas a hacerlo.
Fuente: https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html

Métodos estáticos: Son métodos que pueden tener una implementación en la interfaz
y pueden ser llamados sin una instancia de la clase que implementa la interfaz.
Fuente: https://www.javaguides.net/2018/07/java-8-static-and-default-methods-in-interface.html
(EL MÉTODO QUE USARÉ)
 */
public interface Imprimible {
    static void imprimir(Imprimible documento){
        System.out.println(documento.obtenerContenidoParaImprimir());
    }
    String obtenerContenidoParaImprimir();
    /*El método estático imprimir de la interfaz Imprimible toma un objeto que implementa
    dicha interfaz y llama al método obtenerContenidoParaImprimir() de ese objeto.
    Esto es posible porque cualquier clase que implemente Imprimible debe proporcionar
    una implementación de obtenerContenidoParaImprimir(), asegurando que el objeto pueda generar
    el contenido a imprimir. Esto se define en cada Override
     */
}

/*Por tanto, no solo es posible que las interfaces tengan métodos,
sino que estos métodos pueden tener implementaciones concretas gracias
a las funcionalidades añadidas en versiones más recientes de Java. Esto
ha permitido una mayor flexibilidad y reutilización de código,
permitiendo a las interfaces proporcionar no solo contratos de métodos,
sino también implementaciones reutilizables.
 */