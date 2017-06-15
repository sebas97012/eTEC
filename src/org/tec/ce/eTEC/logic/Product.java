package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;

/**
 * Created by Arturo on 14/6/2017.
 */
public class Product implements Comparable<Product>{
    private String name;
    private String description;
    private LinkedList<Integer> shopsID;
    private int cost;

    /**
     * Constructor
     * @param name Nombre del producto
     * @param description Descripcion
     * @param cost Costo
     */
    public Product(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.shopsID = new LinkedList<>();
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LinkedList<Integer> getShopsID() {
        return shopsID;
    }

    public int getCost() {
        return cost;
    }

    /**
     * Metodo para añadir el objeto al catalogo de una tienda
     * @param shopID
     */
    public void addToShop(int shopID){
        shopsID.insertAtEnd(shopID);
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }
}
