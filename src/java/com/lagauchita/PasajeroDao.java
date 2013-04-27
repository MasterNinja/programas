
package com.lagauchita;

import com.lagauchita.modelo.Pasajero;
import java.util.List;


public interface PasajeroDao {
    public void insertar(Pasajero pasajero);
    public void actualizar(Pasajero pasajero);
    public void borrar(Pasajero pasajero);
    public Pasajero buscarPorId(Integer id);
    public List<Pasajero> buscarTodos();
}
