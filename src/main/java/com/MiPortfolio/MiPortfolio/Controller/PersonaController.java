package com.MiPortfolio.MiPortfolio.Controller;

import com.MiPortfolio.MiPortfolio.Dto.DtoPersona;
import com.MiPortfolio.MiPortfolio.Entity.Persona;
import com.MiPortfolio.MiPortfolio.Security.Controller.Mensaje;
import com.MiPortfolio.MiPortfolio.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/persona")
@RestController
//@CrossOrigin(origins = {"https://frontend-d69bd.web.app"})
@CrossOrigin(origins = {"http://localhost:4200"})
public class PersonaController {

    @Autowired
    ImpPersonaService Personaservice;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = Personaservice.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    /*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!Personaservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        Personaservice.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id) {
        if (!Personaservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = Personaservice.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    /*
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPersona dtoPersona) {

        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (Personaservice.existsByNombre(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtoPersona.getNombre(),dtoPersona.getApellido(), dtoPersona.getDescripcion(), dtoPersona.getImg());

        Personaservice.save(persona);
        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoPersona) {
        //Validamos si existe el ID
        if (!Personaservice.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de personas
        if (Personaservice.existsByNombre(dtoPersona.getNombre()) && Personaservice.getByNombre(dtoPersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoPersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
 
        //Compara apellido de personas
        if (Personaservice.existsByApellido(dtoPersona.getApellido()) && Personaservice.getByApellido(dtoPersona.getApellido()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoPersona.getApellido())) {
            return new ResponseEntity(new Mensaje("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);

        }
        //Compara descripcion de personas
        if (Personaservice.existsByDescripcion(dtoPersona.getDescripcion()) && Personaservice.getByDescrpcion(dtoPersona.getDescripcion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa descripcion ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoPersona.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);

        }
        //Compara img de personas
        if (Personaservice.existsByImg(dtoPersona.getImg()) && Personaservice.getByImg(dtoPersona.getImg()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa imagen ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoPersona.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatorio"), HttpStatus.BAD_REQUEST);

        }

        Persona persona = Personaservice.getOne(id).get();
        persona.setNombre(dtoPersona.getNombre());
        persona.setApellido(dtoPersona.getApellido());
        persona.setDescripcion((dtoPersona.getDescripcion()));
        persona.setImg(dtoPersona.getImg());

        Personaservice.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);

    }
}
