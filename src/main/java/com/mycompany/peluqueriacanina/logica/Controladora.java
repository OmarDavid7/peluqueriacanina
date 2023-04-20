
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nombrePropie, String celPropie, String alergico, String atencionEspe) {
        //creamos al dueño y le asignamos sus valores
        Propietario propie = new Propietario();
        propie.setPropieNombre(nombrePropie);
        propie.setCelPropie(celPropie);
        
        //creamos la mascota y le asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencionEspecial(atencionEspe);
        masco.setObservaciones(observaciones);
        masco.setProp(propie);
        
        controlPersis.guardar(propie,masco);
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarmascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
       return controlPersis.traerMascota(num_cliente);
               
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, 
            String observaciones, String alergico, String atencionEspe, String nombrePropie, String celPropie) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencionEspecial(atencionEspe);
        masco.setAlergico(alergico);
        
        //modifico la mascota
        controlPersis.modificarMascota(masco);
        
        //seteo nuevos valores del dueño
        Propietario dueno = this.buscarDuenio(masco.getProp().getIdPropie());
        dueno.setCelPropie(celPropie);
        dueno.setPropieNombre(nombrePropie);
        
        //llamar modificar dueño
        this.modificarDueno(dueno);
    }

    private Propietario buscarDuenio(int idPropie) {
        return controlPersis.traerDuenio(idPropie);
    }

    private void modificarDueno(Propietario dueno) {
      controlPersis.modificarDuenio(dueno);
    }
}
