/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lagauchita.beans;

import com.lagauchita.PasajeroDao;
import com.lagauchita.impl.PasajeroDaoImp;
import com.lagauchita.modelo.Pasajero;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Federico
 */
@ManagedBean
@SessionScoped
public class AltaBean {

    Pasajero pasajero;

    public AltaBean() {
        pasajero = new Pasajero();
    }

    public Pasajero getPasajero() {
        if(pasajero == null){
            pasajero = new Pasajero();
        }
        return pasajero;
    }

    public String guardar() {
        PasajeroDao pasajeroDao = new PasajeroDaoImp();
        pasajeroDao.insertar(pasajero);
        pasajero = null;
        return "index";
    }
}
