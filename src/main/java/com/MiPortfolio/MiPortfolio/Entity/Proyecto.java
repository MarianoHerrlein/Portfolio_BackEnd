package com.MiPortfolio.MiPortfolio.Entity;

import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int Id;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;
    @NotNull 
    private String link;

    private String img;

    //constructores

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String link, String img) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.link = link;
        this.img = img;
    }
   
    //getter and setter

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
