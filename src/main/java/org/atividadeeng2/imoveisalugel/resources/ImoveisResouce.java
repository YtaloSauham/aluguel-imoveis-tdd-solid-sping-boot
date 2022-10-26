package org.atividadeeng2.imoveisalugel.resources;


import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.atividadeeng2.imoveisalugel.services.ImoveisServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/imovel")

public class ImoveisResouce {

    @Autowired
    private ImoveisServices imoveisServices;

    @GetMapping
    public ResponseEntity<List<Imoveis>> findAllImoveis(){
        List<Imoveis> listImoveisFromRepository = imoveisServices.findAllImoveissFromRepository();
        return ResponseEntity.ok().body(listImoveisFromRepository);
    }

    @GetMapping(value = "/{bairro}")
    public ResponseEntity<List<Imoveis>> findImoveisByBairro(@PathVariable String bairro){
        List<Imoveis> listImoveisFromRepository = imoveisServices.findImoveisByBairroFromRepository(bairro);
        return ResponseEntity.ok().body(listImoveisFromRepository);
    }

    @PostMapping
    public ResponseEntity<Imoveis> insertImoveis(@RequestBody Imoveis imoveis){
        imoveis = imoveisServices.insertImoveisFromRepository(imoveis);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(imoveis.getId())
                .toUri();
        return ResponseEntity.created(uri).body(imoveis);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        imoveisServices.deleteImoveisById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Imoveis> update(@PathVariable Long id, @RequestBody Imoveis Imoveis){
        Imoveis = imoveisServices.update(id,Imoveis);
        return ResponseEntity.ok().body(Imoveis);
    }



}
