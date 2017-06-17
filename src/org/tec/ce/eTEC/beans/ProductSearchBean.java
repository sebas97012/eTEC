package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Product;
import org.tec.ce.eTEC.logic.SearchProductCoincidence;
import org.tec.ce.eTEC.searchs_sorts.SortAlgorithms;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arturo on 15/6/2017.
 */
@ManagedBean(name= "productsearch")
@SessionScoped
public class ProductSearchBean implements Serializable{
    private String searchParam = "";
    private String orderingAttribute = "";
    private String orderingAlgorithm = "";
    private LinkedList coincidencesList;
    private List<Product> listFound;
    private Product currentProduct;         //Para saber cuál producto se está viendo

    /*
    @ManagedProperty("#{productsservice}")
    private ProductSearchService service;

    public void setService(ProductSearchService service){
        this.service = service;
    }

    @PostConstruct
    public void init(){
        listFound = service.createList(coincidencesList, coincidencesList.getSize());
    }*/

    public String getSearchParam() {
        return searchParam;
    }

    public void setSearchParam(String searchParam) {
        this.searchParam = searchParam;
    }

    public String getOrderingAttribute() {
        return orderingAttribute;
    }

    public void setOrderingAttribute(String orderingAttribute) {
        this.orderingAttribute = orderingAttribute;
    }

    public String getOrderingAlgorithm() {
        return orderingAlgorithm;
    }

    public void setOrderingAlgorithm(String orderingAlgorithm) {
        this.orderingAlgorithm = orderingAlgorithm;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public List<Product> getListFound() {
        return listFound;
    }

    public void setListFound(List<Product> listFound) {
        listFound = listFound;
    }

    public String searchProduct(){
        if(searchParam.length() > 0 && orderingAlgorithm.length() > 0) {
            coincidencesList = SearchProductCoincidence.searchCoincidenceDescription(searchParam);
            orderProducts(coincidencesList, orderingAlgorithm);

            listFound = new ArrayList<Product>();

            for (int i = 0; i < coincidencesList.getSize(); i++){
                listFound.add((Product) coincidencesList.getElement(i).getDataT());
            }
            //listFound = service.createList(coincidencesList, coincidencesList.getSize());

            return "success";
        } else{
            return "error";
        }
    }

    public LinkedList getCoincidencesList(){
        return coincidencesList;
    }

    public void setCoincidencesList(LinkedList coincidencesList){
        this.coincidencesList = coincidencesList;
    }

    private void orderProducts(LinkedList list, String orderingAlgorithm){
        int algorithm = Integer.valueOf(orderingAlgorithm);

        switch (algorithm){
            case 1:
                SortAlgorithms.selectionSort(list);
                break;
            case 2:
                SortAlgorithms.bubbleSort(list);
                break;
            case 3:
                SortAlgorithms.insertionSort(list);
                break;
            case 4:
                SortAlgorithms.shellSort(list);
                break;
            case 5:
                SortAlgorithms.mergeSort(list);
                break;
            case 6:
                SortAlgorithms.quickSort(list);
                break;
            case 7:
                SortAlgorithms.radixSort(list);
                break;
        }
    }
}
