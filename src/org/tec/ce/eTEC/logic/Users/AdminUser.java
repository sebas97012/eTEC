package org.tec.ce.eTEC.logic.Users;

import org.tec.ce.eTEC.logic.Establishment;

import static org.tec.ce.eTEC.ApplicationManager.eTECManager;

/**
 * Created by Arturo on 14/6/2017.
 */
public class AdminUser extends User{
    /**
     * Constructor
     * @param userName Nombre de usuario
     * @param password Contraseña
     */
    private String Name;

    public AdminUser(String Name, String password,String userName) {
        this.userName = userName;
        this.password = password;
        this.Name=Name;
    }

    /**
     * Metodo para añadir un nuevo establecimiento
     * @param establishment Establecimiento a añadir
     */
    public void addEstablishment(Establishment establishment){
        eTECManager.addEstablishment(establishment);
    }

    /**
     * Metodo para remover un establecimiento
     * @param establishment Establecimiento a eliminar
     */
    public void removeShop(Establishment establishment){
        eTECManager.removeEstablishment(establishment);
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
