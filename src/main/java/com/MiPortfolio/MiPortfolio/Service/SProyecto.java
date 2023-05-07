package com.MiPortfolio.MiPortfolio.Service;

import com.MiPortfolio.MiPortfolio.Entity.Proyecto;
import com.MiPortfolio.MiPortfolio.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {

    @Autowired
    RProyecto rProyecto;

    public List<Proyecto> list() {
        return rProyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return rProyecto.findById(id);
    }

    public Optional<Proyecto> getByNombre(String nombre) {
        return rProyecto.findByNombre(nombre);
    }

    public Optional<Proyecto> getByLink(String link) {
        return rProyecto.findByLink(link);
    }

    public Optional<Proyecto> getByDescrpcion(String descripcion) {
        return rProyecto.findByDescripcion(descripcion);
    }

    public Optional<Proyecto> getByImg(String img) {
        return rProyecto.findByImg(img);
    }

    public void save(Proyecto proyecto) {
        rProyecto.save(proyecto);
    }

    public void delete(int id) {
        rProyecto.deleteById(id);
    }

    public boolean existsById(int id) {
        return rProyecto.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return rProyecto.existsByNombre(nombre);
    }

    public boolean existsByLink(String link) {
        return rProyecto.existsByLink(link);
    }

    public boolean existsByDescripcion(String descripcion) {
        return rProyecto.existsByDescripcion(descripcion);
    }

    public boolean existsByImg(String img) {
        return rProyecto.existsByImg(img);
    }
}
