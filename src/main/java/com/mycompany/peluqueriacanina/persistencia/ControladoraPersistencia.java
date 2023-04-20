
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.logica.Propietario;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    //instancias de los dos jpacontrollers que vamos a usar
    PropietarioJpaController propieJpa = new PropietarioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Propietario propie, Mascota masco) {
        //crear en la BD el dueño
        propieJpa.create(propie);
        
        //crear en la BD la mascota
        mascotaJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
      return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
       return mascotaJpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) { 
        try {
            mascotaJpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Propietario traerDuenio(int idPropie) {
       return propieJpa.findPropietario(idPropie);
    }

    public void modificarDuenio(Propietario dueno) {
        try {
            propieJpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
