package org.tec.ce.eTEC.logic;

import org.tec.ce.eTEC.datastructures.LinkedList;

import java.io.IOException;

/**
 * Created by Arturo on 14/6/2017.
 */
public class IDGenerator {
    private LinkedList<Integer> establishmentsIDs;
    private LinkedList<Integer> packagesIDs;

    /**
     * Constructor
     */
    public IDGenerator(){
        try {
            //Se trata de obtener la lista de ids del archivo xml
            if(FileXMLManager.checkExistence("establishmentsIDs.xml") == true){ //Se verifica la existencia del xml
                this.establishmentsIDs = (LinkedList) FileXMLManager.getContent("establishmentsIDs.xml"); //Se extrae el objeto almacenado en el xml
            } else {
                this.establishmentsIDs = new LinkedList(); //Se crea una nueva lista
                FileXMLManager.writeContent(establishmentsIDs, "establishmentsIDs.xml"); //Se guarda la lista en un nuevo archivo xml
            }

            //Se trata de obtener la lista de ids del archivo xml
            if(FileXMLManager.checkExistence("packagesIDs.xml") == true){ //Se verifica la existencia del xml
                this.packagesIDs = (LinkedList) FileXMLManager.getContent("packagesIDs.xml"); //Se extrae el objeto almacenado en el xml
            } else{
                this.packagesIDs = new LinkedList<Integer>(); //Se crea una nueva lista
                FileXMLManager.writeContent(packagesIDs, "packagesIDs.xml"); //Se guarda la lista en un nuevo archivo xml
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para crear un nuevo ID para un paquete
     * @return
     */
    public int createPackageID(){
        int newID = Random.getRamdomNumber(100000, 999999);

        if(verifyUse(packagesIDs, newID) == true){
            return createPackageID();
        } else{
            packagesIDs.insertAtEnd(newID);
            FileXMLManager.writeContent(packagesIDs, "packagesIDs.xml");
            return newID;
        }
    }

    /**
     * Metodo para crear un nuevo ID para un establecimiento
     * @return
     */
    public int createEstablishmentID(){
        int newID = Random.getRamdomNumber(100000, 999999);

        if(verifyUse(establishmentsIDs, newID) == false){
            establishmentsIDs.insertAtEnd(newID);
            FileXMLManager.writeContent(establishmentsIDs, "packagesIDs.xml");
            return newID;
        } else{
            return createEstablishmentID();
        }
    }

    /**
     * Metodo que verifica si un ID esta en uso
     * @param list Lista en la que verificar
     * @param id ID que se desea verificar el uso
     * @return True si esta en uso, false en caso contrario
     */
    private boolean verifyUse(LinkedList list, int id){
        boolean existence = false;

        for (int i = 0; i < list.getSize(); i++) {
            if (list.getElement(i).getDataT().compareTo(id) == 0){
                existence = true;
            }
        }

        return existence;
    }
}
