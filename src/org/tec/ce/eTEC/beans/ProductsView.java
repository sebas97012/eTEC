package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Arturo on 15/6/2017.
 */
@ManagedBean(name = "producstview")
@ViewScoped
public class ProductsView {
    private LinkedList<Product> products;

    public LinkedList<Product> getProducts() {
        return products;
    }
}
