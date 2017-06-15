package org.tec.ce.eTEC.logic.Users;

import org.tec.ce.eTEC.logic.Package;
import org.tec.ce.eTEC.logic.Product;
import org.tec.ce.eTEC.logic.Shop;

/**
 * Created by sebas97012 on 6/14/17.
 */
public class ShopUser extends AdminUser{
    private Shop shop;

    /**
     * Constructor
     * @param userName Nombre de usuario
     * @param password Contraseña
     * @param shop Tienda para la que trabaja el usuario
     */
    public ShopUser(String userName, String password, Shop shop) {
        super(userName, password);
        this.shop = shop;
    }

    /**
     * Metodo para añadir un producto a la tienda
     * @param product Producto a añadir
     */
    public void addProduct(Product product){
        shop.addProduct(product);
    }

    /**
     * Metodo para eliminar un producto de la tienda
     * @param product Producto a eliminar
     */
    public void removeProduct(Product product){
        shop.removeProduct(product);
    }
}
