public interface IPrintable{
    default void print(){
        System.out.println(this);
    }
}
