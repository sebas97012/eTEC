package org.tec.ce.eTEC.logic.Users;

import org.tec.ce.eTEC.logic.DistributionCenter;

/**
 * Created by sebas97012 on 6/14/17.
 */
public class DistributionCenterUser extends AdminUser{
    private DistributionCenter distributionCenter;

    /**
     * Constructor
     * @param userName Nombre de usuario
     * @param password Contraseña
     */
    public DistributionCenterUser(String userName, String password, DistributionCenter distributionCenter) {
        super(userName, password);
        this.distributionCenter = distributionCenter;
    }
}
