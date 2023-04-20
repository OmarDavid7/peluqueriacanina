
package com.mycompany.peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Propietario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int idPropie;
    
    @Basic
    private String propieNombre;
    private String celPropie;

    public Propietario() {
    }

    public Propietario(int idPropie, String propieNombre, String celPropie) {
        this.idPropie = idPropie;
        this.propieNombre = propieNombre;
        this.celPropie = celPropie;
    }

    public int getIdPropie() {
        return idPropie;
    }

    public void setIdPropie(int idPropie) {
        this.idPropie = idPropie;
    }

    public String getPropieNombre() {
        return propieNombre;
    }

    public void setPropieNombre(String propieNombre) {
        this.propieNombre = propieNombre;
    }

    public String getCelPropie() {
        return celPropie;
    }

    public void setCelPropie(String celPropie) {
        this.celPropie = celPropie;
    }
    
    
}
