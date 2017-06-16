package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.Graph;
import org.tec.ce.eTEC.datastructures.LinkedList;
import org.tec.ce.eTEC.logic.Users.*;

import java.io.IOException;

/**
 * Created by Arturo on 14/6/2017.
 */
public class eTECManager {
    private Graph establishmentsGraph;
    private LinkedList<User> usersList;
    private LinkedList<Product> productsList;

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

    public LinkedList<Product> getProductsList() {
        return productsList;
    }

    /**
     * Metodo para añadir un nuevo establecimiento al grafo
     * @param establishment Establecimiento a agregar
     */
    public void addEstablishment(Establishment establishment){
        establishmentsGraph.addVertex(establishment);
        updateEstablishmentsGraph(); //Se actualiza el grafo almacenado en el xml
    }

    /**
     * Metodo para remover un establecimiento del grafo
     * @param establishment
     */
    public void removeEstablishment(Establishment establishment){
        establishmentsGraph.removeVertex(establishment);
        updateEstablishmentsGraph(); //Se actualiza el grafo almacenado en el xml
    }

    /**
     * Metodo para añadir un nuevo usuario
     * @param user
     */
    public void addUser(User user){
        usersList.insertAtEnd(user);
        updateUsersList(); //Se actualiza la lista de usuarios almacenada en el xml
    }

    /**
     * Metodo para eliminar un usuario
     * @param user
     */
    public void removeUser(User user){
        usersList.deleteElement(user);
        updateUsersList(); //Se actualiza la lista de usuarios almacenada en el xml
    }

    /**
     * Metodo para obtener un usuario de la lista
     * @param userName Nombre de usuario del usuario
     * @return El usuario si hubo alguna coincidencia, null si no la hubo
     */
    public User getUser(String userName){
        User user = null;
        for (int i = 0; i < usersList.getSize(); i++) { //Se recorre toda la lista de usuarios en busca del que coincida con el nombre
            User current = (User) usersList.getElement(i).getDataT();  //de usuario ingresado
            if(current.getUserName().equals(userName)){
                user = current; //Si los nombres son iguales, se retorna este usuario
            }
        }
        return user;
    }

    /**
     * Metodo para añadir un producto
     * @param product Producto a agregar
     */
    public void addProduct(Product product){
        productsList.insertAtEnd(product);
        updateProductsList();
    }

    /**
     * Metodo para eliminar un producto
     * @param product Producto a eliminar
     */
    public void removeProduct(Product product){
        productsList.deleteElement(product);
        updateProductsList();
    }

    /**
     * Metodo para actualizar el grafo almacenado en el xml
     */
    private void updateEstablishmentsGraph(){
        FileXMLManager.writeContent(establishmentsGraph, "establishments.xml"); //Se actualiza el grafo
    }

    /**
     * Metodo para actualizar la lista de usuarios almacenada en el xml
     */
    private void updateUsersList(){
        FileXMLManager.writeContent(usersList, "users.xml");
    }

    /**
     * Metodo para actualizar la lista de productos en el xml
     */
    private void updateProductsList(){
        FileXMLManager.writeContent(productsList, "products.xml");
    }
}
