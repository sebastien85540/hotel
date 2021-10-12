package com.m2i.hotelbackend.api;

import com.m2i.hotelbackend.model.Hotel;
import com.m2i.hotelbackend.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/api/hotel")
public class HotelAPIController {

    @Autowired
    HotelService hotelService;

    @GetMapping(path = "", produces = "application/json")
    public Iterable<Hotel> getAll(HttpServletRequest request){
        return hotelService.getList(request.getParameter("search"));
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Hotel> get(@PathVariable("id") int id){
        try {
            Hotel hotel = hotelService.find(id);
            return ResponseEntity.ok()
                    .body(hotel);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Hotel> add(@RequestBody Hotel hotel){
        try {
            Hotel createHotel = hotelService.addHotel(hotel.getNom(), hotel.getEtoiles(), hotel.getAdresse(), hotel.getTelephone(), hotel.getEmail(), hotel.getVille());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createHotel.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(createHotel);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Hotel> edit(@RequestBody Hotel hotel, @PathVariable("id") int id){
        try {
            Hotel editHotel = hotelService.editHotel(id, hotel.getNom(), hotel.getEtoiles(), hotel.getAdresse(), hotel.getTelephone(), hotel.getEmail(), hotel.getVille());
            return ResponseEntity.ok()
                    .body(editHotel);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        try {
            hotelService.delete(id);
            return ResponseEntity.ok()
                    .body(null);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
