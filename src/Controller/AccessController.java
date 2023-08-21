/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Core.DB;
import Helper.DBException;
import Model.AccessModel;
import View.SignIn;

/**
 *
 * @author MINH
 */
public class AccessController extends DB {
    private AccessModel accessModel;
    private SignIn signInView;

    public AccessController(AccessModel accessModel, SignIn signInView) throws DBException {
        this.accessModel = accessModel;
        this.signInView = signInView;
    }
    
    public void SignIn(String username, String password) {
        try {
            boolean isAuthenticated = accessModel.authenticate(username, password);
            signInView.resultAccess(isAuthenticated);
        } catch (DBException dbException) {
            signInView.Error("An error occurred: " + dbException.getMessage());
        }
    }
}
