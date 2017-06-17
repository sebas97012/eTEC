package org.tec.ce.eTEC.beans;

/**
 * Created by pelon_000 on 16/06/2017.
 */

import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Product;
import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;

import static org.tec.ce.eTEC.ApplicationManager.IDGenerator;

@ManagedBean(name="products")
public class ProductBean {
    private String name;
    private String description;
    private LinkedList<Integer> shopsID;
    private int id;
    private int cost;
    private String shop;
    private int cantidad;


    public String addProduct(){
        for (int i = 0; i < this.cantidad; i++) {
            this.id = IDGenerator.createEstablishmentID();
            Product product1 = new Product(this.name, this.description, this.cost, this.id);
            eTECManager.addProduct(product1);


        }
        return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
