/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sainsmanajement;

import java.util.LinkedList;
/**
 *
 * @author ASUS
 */
public class Obj {
    String name;
    double Capacity;
    double Request;
    boolean isExpedition;

    public Obj(String name, boolean isExpedition) {
        this.name=name;
        this.isExpedition=isExpedition;   
    }
    public Obj(String name, int Capacity, int Request, boolean isExpedition) {
        this.name=name;
        this.Capacity=Capacity;
        this.Request=Request;
        this.isExpedition=isExpedition;   
    }
    
}
