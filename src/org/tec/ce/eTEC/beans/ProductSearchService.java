package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Product;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "productsservice")
@SessionScoped
public class ProductSearchService implements Serializable{
    public List<Product> createList(LinkedList lista, int size) {
        List<Product> ListFound = new ArrayList<Product>();

        for (int i = 0; i < lista.getSize(); i++){
            ListFound.add((Product) lista.getElement(i).getDataT());
        }
        return ListFound;
    }
}
