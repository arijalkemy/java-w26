package view.options;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import api.APISuperMarket;
import models.Product;
import view.MainMenu;
import view.View;

public class AddProductOption extends AbstractOption {

    public AddProductOption()
    {
        this.messageOption = "1. Agregar un producto";
        this.id = 1;
    }

    @Override
    public void execAction() {

        Map<String, Product> mapProducts = APISuperMarket.getInstance().getItems();
        List<IOption> options = new ArrayList<>();
        int ids = 1;
        for (Map.Entry<String, Product> iterable : mapProducts.entrySet()) {
            options.add(ProductOption.of(ids, iterable.getValue()));
            ids++;
        }
        IOption optionBack = new MainMenu(ids);
        options.add(optionBack);

        IOption optionSelected =  View.requestAction(options.toArray(new IOption[options.size()]));
        optionSelected.execAction();
        this.execAction();
    }

    @Override
    public void showAction() {
        System.out.println(this.messageOption);
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }


    
}
