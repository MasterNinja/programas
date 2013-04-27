
package com.lagauchita.impl;

import com.lagauchita.PasajeroDao;
import com.lagauchita.modelo.Pasajero;
import com.lagauchita.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class PasajeroDaoImp implements PasajeroDao{

    @Override
    public void insertar(Pasajero pasajero) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(pasajero);
            session.beginTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en insertar"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void actualizar(Pasajero pasajero) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(pasajero);
            session.beginTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en actualizar"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public void borrar(Pasajero pasajero) {
       Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(pasajero);
            session.beginTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en borrar"+e.getMessage());
            session.beginTransaction().rollback();
        }
    }

    @Override
    public Pasajero buscarPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Pasajero) session.load(Pasajero.class, id);
    }

    @Override
    public List<Pasajero> buscarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Pasajero").list();
    }
    
}
