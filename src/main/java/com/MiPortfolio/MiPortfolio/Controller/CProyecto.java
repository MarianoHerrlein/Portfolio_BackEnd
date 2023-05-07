
package com.MiPortfolio.MiPortfolio.Controller;

import com.MiPortfolio.MiPortfolio.Dto.DtoProyecto;
import com.MiPortfolio.MiPortfolio.Entity.Proyecto;
import com.MiPortfolio.MiPortfolio.Security.Controller.Mensaje;
import com.MiPortfolio.MiPortfolio.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/proyecto")
@RestController
//@CrossOrigin(origins = {"https://frontend-d69bd.web.app"})
@CrossOrigin(origins = {"http://localhost:4200"})
public class CProyecto {
    
    @Autowired
    SProyecto Sproyecto;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = Sproyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!Sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        Sproyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminada"), HttpStatus.OK);
    }
     
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!Sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = Sproyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {

        if (StringUtils.isBlank(dtoProyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (Sproyecto.existsByNombre(dtoProyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa proyecto existe"), HttpStatus.BAD_REQUEST);
        }
        Proyecto proyecto = new Proyecto(dtoProyecto.getNombre(),dtoProyecto.getLink(), dtoProyecto.getDescripcion(), dtoProyecto.getImg());

        Sproyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregada"), HttpStatus.OK);
    }
     
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {
        //Validamos si existe el ID
        if (!Sproyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de proyectos
        if (Sproyecto.existsByNombre(dtoProyecto.getNombre()) && Sproyecto.getByNombre(dtoProyecto.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoProyecto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
 
        //Compara link de proyectos
        if (Sproyecto.existsByLink(dtoProyecto.getLink()) && Sproyecto.getByLink(dtoProyecto.getLink()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoProyecto.getLink())) {
            return new ResponseEntity(new Mensaje("El link es obligatorio"), HttpStatus.BAD_REQUEST);

        }
        //Compara descripcion de proyectos
        if (Sproyecto.existsByDescripcion(dtoProyecto.getDescripcion()) && Sproyecto.getByDescrpcion(dtoProyecto.getDescripcion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa descripcion ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoProyecto.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatorio"), HttpStatus.BAD_REQUEST);

        }
        //Compara img de proyectos
        if (Sproyecto.existsByImg(dtoProyecto.getImg()) && Sproyecto.getByImg(dtoProyecto.getImg()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa imagen ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtoProyecto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatorio"), HttpStatus.BAD_REQUEST);

        }

        Proyecto proyecto = Sproyecto.getOne(id).get();
        proyecto.setNombre(dtoProyecto.getNombre());
        proyecto.setLink(dtoProyecto.getLink());
        proyecto.setDescripcion((dtoProyecto.getDescripcion()));
        proyecto.setImg(dtoProyecto.getImg());

        Sproyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);

    }

}
