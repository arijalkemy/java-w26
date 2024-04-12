public static void main(String[] args){
    //Mensaje final
    String mensajeFinal = "Este es el último mensaje";
    
    //Código que arroja excepción
    int[] numeros = new int[5];
    int indice = 5;
    
    try{
        if(indice >= numeros.length)
        throw new Exception("El indice esta fuera del rango");
        
        numeros[indice] = 10;
    }catch (Exception e){
        System.out.println("Error: " + e);
    }finally{
        System.out.println(mensajeFinal);
    }
    
}


    
