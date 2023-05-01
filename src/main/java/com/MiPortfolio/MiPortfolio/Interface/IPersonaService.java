
package com.MiPortfolio.MiPortfolio.Interface;

import com.MiPortfolio.MiPortfolio.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    
//traer una lista de personas
public List<Persona>getPersona();

//guarda un objeto persona

public void savePersona (Persona persona);

//eliminar un ususarios por id

//eliminar un objeto, pero lo buscamos por id
public void delatePersona(Long id);

//buscar una persona
public Persona fiendPersona(Long id);

public Persona findPersona(Long l);
}


