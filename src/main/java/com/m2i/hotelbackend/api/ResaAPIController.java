package com.m2i.hotelbackend.api;

import com.m2i.hotelbackend.model.Resa;
import com.m2i.hotelbackend.services.ResaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/api/reservation")
public class ResaAPIController {

    @Autowired
    ResaService resaService;

    @GetMapping(path = "", produces = "application/json")
    public Iterable<Resa> getAll(HttpServletRequest request){
        return resaService.getList(request.getParameter("search"));
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Resa> get (@PathVariable("id") int id){
        try {
            Resa reservation = resaService.find(id);
            return ResponseEntity.ok()
                    .body(reservation);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Resa> add(@RequestBody Resa resa){
        try {
            Resa createResa = resaService.addResa(resa.getClient().getId(), resa.getHotel().getId(), resa.getDateDebut(), resa.getDateFin(), resa.getNumChambre());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createResa.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(createResa);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Resa> edit(@RequestBody Resa resa, @PathVariable("id") int id){
        try {
            Resa editResa = resaService.edit(id, resa.getClient().getId(), resa.getHotel().getId(), resa.getDateDebut(), resa.getDateFin(), resa.getNumChambre());
            return ResponseEntity.ok()
                    .body(editResa);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        try {
            resaService.delete(id);
            return ResponseEntity.ok()
                    .body(null);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
