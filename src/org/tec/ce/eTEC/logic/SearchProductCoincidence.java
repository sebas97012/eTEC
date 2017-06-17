package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;
import sun.awt.image.ImageWatched;

import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

/**
 * Created by Arturo on 15/6/2017.
 */
public class SearchProductCoincidence {
    /**
     * Metodo para buscar una coincidencia de un producto segun el nombre
     * @param name Nombre que se esta buscando
     * @return Lista con todas las coincidencias
     */
	public static LinkedList searchCoincidenceName(String name){
		LinkedList<Product> results = new LinkedList<Product>(); //Lista en la que se guardan las coincidencias
		LinkedList<Product> productsList = eTECManager.getProductsList(); //Lista de todos los productos

		for (int i = 0; i < productsList.getSize(); i++) {
			Product product = (Product) productsList.getElement(i).getDataT();

			if(searchCoincidenceString(product.getName(), name)){
				results.insertAtEnd(product);
			}
		}

		return results;
	}

    /**
     * Metodo para buscar una coincidencia de un producto segun la descripcion
     * @param description Descripcion que se esta buscando
     * @return Lista con todas las coincidencias
     */
	public static LinkedList searchCoincidenceDescription(String description){
		LinkedList<Product> results = new LinkedList<Product>(); //Lista en la que se guardan las coincidencias
        LinkedList<Product> productsList = eTECManager.getProductsList(); //Lista de todos los productos

		for (int i = 0; i < productsList.getSize(); i++) {
			Product product = (Product) productsList.getElement(i).getDataT();

			if(searchCoincidenceString(product.getDescription(), description)){
				results.insertAtEnd(product);
			}
		}

		return results;
	}

    /**
     * Metodo para buscar una coincidencia de un producto segun el costo
     * @param costMin Costo minimo del producto
     * @param costMax Costo maximo del producto
     * @return Lista con todas las coincidencias
     */
	public static LinkedList searchCoincidenceCost(int costMin, int costMax){
		LinkedList<Product> results = new LinkedList<Product>(); //Lista en la que se guardan las coincidencias
        LinkedList<Product> productsList = eTECManager.getProductsList(); //Lista de todos los productos

		for (int i = 0; i < productsList.getSize(); i++) {
			Product product = (Product) productsList.getElement(i).getDataT();

			if(costMin <= product.getCost() && product.getCost() <= costMax){
				results.insertAtEnd(product);
			}
		}

		return results;
	}

    /**
     * Metodo para buscar si existe una coincidencia entre dos cadenas ingresadas
     * @param whereSearch Cadena en la que se desea buscar la coincidencia
     * @param whatSearch Lo que se esta buscando
     * @return True si hay coincidencia, false en caso contrario
     */
	private static boolean searchCoincidenceString(String whereSearch,  String whatSearch) {
		boolean coincidence = false;
		String[] searchParam = whatSearch.split("\\s+");
		for (String search : searchParam) {
			if (whereSearch.contains(search)) {
				coincidence = true; //La cadena ingresada si contiene el parametro ingresado
			}
		}
		return coincidence;
	}
}
