package view.options;

import data.ShoppingCarRepository;
import models.Product;

public class ProductOption extends AbstractOption {
    private Product item;

    public ProductOption(int id , Product item)
    {
        this.item = item;
        this.id = id;
    }

    @Override
    public void execAction() {
        ShoppingCarRepository.addItem(item);
    }

    @Override
    public void showAction() {
        System.out.println(id + ": " + item.getName());
    }

    @Override
    public String getId() {
        return String.valueOf(id);
    }
    
    public static ProductOption of(int id, Product item)
    {
        return new ProductOption(id, item);
    }
}