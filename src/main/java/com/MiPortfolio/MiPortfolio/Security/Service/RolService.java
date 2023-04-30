package com.MiPortfolio.MiPortfolio.Security.Service;

import com.MiPortfolio.MiPortfolio.Security.Entity.Rol;
import com.MiPortfolio.MiPortfolio.Security.Enums.RolNombre;
import com.MiPortfolio.MiPortfolio.Security.Repository.iRolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {

    @Autowired
    iRolRepository irolRepository;

    public Optional<Rol> getbyRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        irolRepository.save(rol);
    }
}
