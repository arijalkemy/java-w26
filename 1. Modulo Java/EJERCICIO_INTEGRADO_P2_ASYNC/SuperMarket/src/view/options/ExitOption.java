package view.options;

public class ExitOption extends AbstractOption {

    public ExitOption()
    {
        this.id = 3;
    }

    @Override
    public void execAction() {
        System.exit(1);
    }

    @Override
    public void showAction() {
        System.out.println(this.id + ". Salir.");
    }

    
}
