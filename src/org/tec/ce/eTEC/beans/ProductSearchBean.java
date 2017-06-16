package org.tec.ce.eTEC.beans;

import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.SearchProductCoincidence;
import org.tec.ce.eTEC.searchs_sorts.SortAlgorithms;

import javax.faces.bean.ManagedBean;

/**
 * Created by Arturo on 15/6/2017.
 */
@ManagedBean(name= "productsearch")
public class ProductSearchBean {
    private String searchParam = "";
    private String orderingAttribute = "";
    private String orderingAlgorithm = "";

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

    public String searchProduct(){
        if(searchParam.length() > 0 && orderingAlgorithm.length() > 0){
            LinkedList coincidencesList = SearchProductCoincidence.searchCoincidenceDescription(searchParam);
            orderProducts(coincidencesList, orderingAlgorithm);
            return "success";
        } else{
            return "error";
        }
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
