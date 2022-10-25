package org.atividadeeng2.imoveisalugel.resources;


import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.services.AluguelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/aluguel")

public class AluguelResouce {

    @Autowired
    private AluguelServices AluguelServices;

    @GetMapping

    public ResponseEntity<List<Aluguel>> findAllAluguels(){
        List<Aluguel> listAluguelFromRepository = AluguelServices.findAllAluguelsFromRepository();
        return ResponseEntity.ok().body(listAluguelFromRepository);
    }

    @PostMapping
    public ResponseEntity<Aluguel> insertAluguel(@RequestBody Aluguel Aluguel){
        Aluguel = AluguelServices.insertAluguelFromRepository(Aluguel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(Aluguel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(Aluguel);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        AluguelServices.deleteAluguelById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluguel> update(@PathVariable Long id, @RequestBody Aluguel aluguel){
        aluguel = AluguelServices.update(id,aluguel);
        return ResponseEntity.ok().body(aluguel);
    }



}
