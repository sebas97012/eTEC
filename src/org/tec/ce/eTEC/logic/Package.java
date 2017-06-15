package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;

import static org.tec.ce.eTEC.ApplicationManager.IDGenerator;

/**
 * Created by Arturo on 14/6/2017.
 */
public class Package implements Comparable<Package>{
    private LinkedList<Product> productsList;
    private Route route;
    private String status;
    private int code;
    private int cost;

    /**
     * Constructor
     */
    public Package() {
        this.productsList = new LinkedList<Product>();
        this.status = "in_transit";
        this.code = IDGenerator.createPackageID();
        this.cost = 0;
    }

    /**
     * Metodo para añadir un producto a la lista
     * @param product Producto a ser agregado
     */
    public void addProduct(Product product){
        productsList.insertAtEnd(product);
    }

    /**
     * Metodo para remover un producto de la lista
     * @param product Producto a eliminar
     */
    public void removeProduct(Product product){
        productsList.deleteElement(product);
    }

    /**
     * Metodo para calcular el precio total del paquete
     */
    public void calcCost(){
        for (int i = 0; i < productsList.getSize(); i++) {
            Product product = (Product) productsList.getElement(i).getDataT();
            cost += product.getCost();
        }
    }

    @Override
    public int compareTo(Package o) {
        return 0;
    }
}
