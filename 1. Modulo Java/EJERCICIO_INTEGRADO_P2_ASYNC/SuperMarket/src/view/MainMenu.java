package view;

import view.options.AbstractOption;
import view.options.AddProductOption;
import view.options.ExitOption;
import view.options.IOption;
import view.options.PayOption;

public class MainMenu extends AbstractOption {
   
    public MainMenu(int id)
    {
        this.id = id;
    }

    public MainMenu(){}

    public void initApp() {
        this.execAction();
    }

    @Override
    public void execAction() {

        AddProductOption option1 =  new AddProductOption();
        PayOption option2 = new PayOption();
        ExitOption option3 = new ExitOption();

        IOption option = View.requestAction(option1, option2, option3);
        option.execAction();
    }

    @Override
    public void showAction() {
        System.out.println(this.id + ". Main menu.");
    }
   
}
