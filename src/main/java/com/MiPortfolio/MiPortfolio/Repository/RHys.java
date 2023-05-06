package com.MiPortfolio.MiPortfolio.Repository;

import com.MiPortfolio.MiPortfolio.Entity.Hys;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHys extends JpaRepository<Hys , Integer> {

    public Optional<Hys> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
