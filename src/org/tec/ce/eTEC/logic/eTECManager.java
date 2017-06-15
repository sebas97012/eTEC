package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.Graph;
import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Users.User;

import java.io.IOException;

/**
 * Created by Arturo on 14/6/2017.
 */
public class eTECManager {
    private static Graph establishmentsGraph;
    private static LinkedList<User> usersList;
    private static LinkedList<Product> productsList;

    /**
     * Constructor
     */
    public eTECManager(){
        try {
            //Se trata de obtener el grafo almacenado en el archivo xml
            if(FileXMLManager.checkExistence("establishments.xml") == true){ //Se verifica la existencia del xml
                this.establishmentsGraph = (Graph) FileXMLManager.getContent("establishments.xml"); //Se extrae el objeto almacenado en el xml
            } else {
                this.establishmentsGraph = new Graph(); //Se crea un nuevo grafo
                FileXMLManager.writeContent(establishmentsGraph, "establishments.xml"); //Se guarda el grafo en un nuevo archivo xml
            }

            //Se trata de obtener la lista de usuarios del archivo xml
            if(FileXMLManager.checkExistence("users.xml") == true){ //Se verifica la existencia del xml
                this.usersList = (LinkedList) FileXMLManager.getContent("users.xml"); //Se extrae el objeto almacenado en el xml
            } else{
                this.usersList = new LinkedList<User>(); //Se crea una nueva lista
                FileXMLManager.writeContent(usersList, "users.xml"); //Se guarda la lista en un nuevo archivo xml
            }

            //Se trata de obtener la lista de productos del archivo xml
            if(FileXMLManager.checkExistence("products.xml") == true){ //Se verifica la existencia del xml
                this.productsList = (LinkedList) FileXMLManager.getContent("products.xml"); //Se extrae el objeto almacenado en el xml
            } else{
                this.productsList = new LinkedList<Product>(); //Se crea una nueva lista
                FileXMLManager.writeContent(productsList, "products.xml"); //Se guarda la lista en un nuevo archivo xml
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para añadir un nuevo establecimiento al grafo
     * @param establishment Establecimiento a agregar
     */
    public static void addEstablishment(Establishment establishment){
        establishmentsGraph.addVertex(establishment);
        updateEstablishmentsGraph(); //Se actualiza el grafo almacenado en el xml
    }

    /**
     * Metodo para remover un establecimiento del grafo
     * @param establishment
     */
    public static void removeEstablishment(Establishment establishment){
        establishmentsGraph.removeVertex(establishment);
        updateEstablishmentsGraph(); //Se actualiza el grafo almacenado en el xml
    }

    /**
     * Metodo para añadir un nuevo usuario
     * @param user
     */
    public static void addUser(User user){
        usersList.insertAtEnd(user);
        updateUsersList(); //Se actualiza la lista de usuarios almacenada en el xml
    }

    /**
     * Metodo para eliminar un usuario
     * @param user
     */
    public static void removeUser(User user){
        usersList.deleteElement(user);
        updateUsersList(); //Se actualiza la lista de usuarios almacenada en el xml
    }

    /**
     * Metodo para añadir un producto
     * @param product Producto a agregar
     */
    public static void addProduct(Product product){
        productsList.insertAtEnd(product);
        updateProductsList();
    }

    /**
     * Metodo para eliminar un producto
     * @param product Producto a eliminar
     */
    public static void removeProduct(Product product){
        productsList.deleteElement(product);
        updateProductsList();
    }

    /**
     * Metodo para actualizar el grafo almacenado en el xml
     */
    private static void updateEstablishmentsGraph(){
        FileXMLManager.writeContent(establishmentsGraph, "establishments.xml"); //Se actualiza el grafo
    }

    /**
     * Metodo para actualizar la lista de usuarios almacenada en el xml
     */
    private static void updateUsersList(){
        FileXMLManager.writeContent(usersList, "users.xml");
    }

    /**
     * Metodo para actualizar la lista de productos en el xml
     */
    private static void updateProductsList(){
        FileXMLManager.writeContent(productsList, "products.xml");
    }
}
