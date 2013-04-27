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
public class EditarBean {

    Pasajero pasajero;

    /**
     * Creates a new instance of EditarBean
     */
    public EditarBean() {
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public String editar(Integer id) {
        PasajeroDao pasajeroDao = new PasajeroDaoImp();
        pasajero = pasajeroDao.buscarPorId(id);
        return "editar";
    }

    public String guardar() {
        PasajeroDao pasajeroDao = new PasajeroDaoImp();
        pasajeroDao.actualizar(pasajero);
        return "index";
    }
}
