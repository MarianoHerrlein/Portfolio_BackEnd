package com.MiPortfolio.MiPortfolio.Repository;

import com.MiPortfolio.MiPortfolio.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RProyecto extends JpaRepository<Proyecto, Integer> {

    public Optional<Proyecto> findByNombre(String nombre);

    public Optional<Proyecto> findByLink(String link);

    public Optional<Proyecto> findByDescripcion(String descripcion);

    public Optional<Proyecto> findByImg(String img);

    public boolean existsByNombre(String nombre);

    public boolean existsByLink(String link);

    public boolean existsByDescripcion(String descripcion);

    public boolean existsByImg(String img);
}
