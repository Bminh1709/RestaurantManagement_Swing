/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Core.DB;
import Model.AccessModel;
import View.SignIn;

/**
 *
 * @author MINH
 */
public class AccessController extends DB{
    private AccessModel accessModel;
    private SignIn signInView;

    public AccessController(AccessModel accessModel, SignIn signInView) {
        this.accessModel = accessModel;
        this.signInView = signInView;
    }
    
    public boolean SignIn(String username, String password) {
        boolean isAuthenticated = accessModel.authenticate(username, password);
        if (isAuthenticated) {
            return true;
        } else {
            return false;
        }
    }
    
}
