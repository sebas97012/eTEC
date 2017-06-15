package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;

/**
 * Created by Arturo on 14/6/2017.
 */
public class Shop extends Establishment {
    private LinkedList<Product> productsList;

    public Shop(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = IDGenerator.createEstablishmentID();
        this.productsList = new LinkedList<Product>();
    }

    public LinkedList<Product> getProductsList() {
        return productsList;
    }

    public void addProduct(Product product){
        productsList.insertAtEnd(product);
    }

    public void removeProduct(Product product){
        productsList.deleteElement(product);
    }

    @Override
    public int compareTo(Establishment o) {
        return 0;
    }
}
