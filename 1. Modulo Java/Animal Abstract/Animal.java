public abstract class Animal<T> {
    public void sound(){
        System.out.println("Animal emitiendo sonido");
    }

    public <Carniboro> void eatAnimal(Animal<T> animal){
        System.out.println(this.getClass()+ " se comio un" + animal.getClass());
    }
}
