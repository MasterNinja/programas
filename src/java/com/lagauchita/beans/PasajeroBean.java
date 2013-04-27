/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lagauchita.beans;

import com.lagauchita.PasajeroDao;
import com.lagauchita.impl.PasajeroDaoImp;
import com.lagauchita.modelo.Pasajero;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Federico
 */
@ManagedBean(name="pasajeroBean")
@SessionScoped
public class PasajeroBean {

    private Pasajero pasajero;
    private List<Pasajero> pasajeros;
    
    public PasajeroBean() {
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public List<Pasajero> getPasajeros() {
        PasajeroDao pasajeroDao = new PasajeroDaoImp();
        pasajeros = pasajeroDao.buscarTodos();
        return pasajeros;
    }

    public String borrar(Integer id){        
        PasajeroDao pasajeroDao = new PasajeroDaoImp();
        pasajero = pasajeroDao.buscarPorId(id);
        pasajeroDao.borrar(pasajero);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("pasajero eliminado exitosamente")); 
        return "index";
    }
}
