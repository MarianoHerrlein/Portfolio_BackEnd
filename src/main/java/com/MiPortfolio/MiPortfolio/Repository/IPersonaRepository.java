package com.MiPortfolio.MiPortfolio.Repository;


import com.MiPortfolio.MiPortfolio.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer>{
  public Optional<Persona> findByNombre(String nombre);
   public Optional<Persona> findByApellido(String apellido);
    public Optional<Persona> findByDescripcion(String descripcion);
     public Optional<Persona> findByImg(String img);

    public boolean existsByNombre(String nombre);
     public boolean existsByApellido(String apellido);
      public boolean existsByDescripcion(String descripcion);
       public boolean existsByImg(String img);
}
