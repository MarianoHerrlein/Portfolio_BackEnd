package com.MiPortfolio.MiPortfolio.Repository;


import com.MiPortfolio.MiPortfolio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}
