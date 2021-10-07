package com.m2i.hotelbackend.api;

import com.m2i.hotelbackend.model.Client;
import com.m2i.hotelbackend.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/api/client")
public class ClientAPIController {

    @Autowired
    ClientService clientService;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Client> getAll(HttpServletRequest request){
        return clientService.getList(request.getParameter("search"));
    }

    @GetMapping(path = "/id", produces = "application/json")
    public ResponseEntity<Client> get(@PathVariable("id") int id){
        try {
            Client client = clientService.find(id);
            return ResponseEntity.ok()
                    .body(client);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(path = "", produces = "application/json")
    public ResponseEntity<Client> add(@RequestBody Client client){
        try {
            Client createClient = clientService.addClient(client.getNomComplet(), client.getTelephone(), client.getEmail(), client.getAdresse());
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createClient.getId())
                    .toUri();
            return ResponseEntity.created(uri)
                    .body(createClient);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

   @PutMapping(path = "/{id}", produces = "application/json")
   public ResponseEntity<Client> edit(@RequestBody Client client, @PathVariable("id") int id){
        try {
            Client editClient = clientService.editClient(id, client.getNomComplet(), client.getTelephone(), client.getEmail(), client.getAdresse());
            return ResponseEntity.ok()
                    .body(editClient);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
   }

   @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") int id){
        try {
            clientService.delete(id);
            return ResponseEntity.ok()
                    .body(null);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
   }

}
