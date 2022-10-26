package org.atividadeeng2.imoveisalugel.resources;


import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.atividadeeng2.imoveisalugel.entities.Locacao;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.services.LocacaoServices;
import org.atividadeeng2.imoveisalugel.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/locacao")

public class LocacaoResouce {

    @Autowired
    private LocacaoServices locacaoServices;
    @Autowired
    private UserServices userServices;

    @GetMapping

    public ResponseEntity<List<Locacao>> findAlllocacaos(){
        List<Locacao> listlocacaoFromRepository = locacaoServices.findAllLocacaosFromRepository();
        return ResponseEntity.ok().body(listlocacaoFromRepository);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<List<Locacao>> findLocacaoByNameClient(@PathVariable String name){
        List<Locacao> listLocacaoFromRepository = locacaoServices.findLocacaoByNameClienFromRepository(userServices.findUserByName(name));
        return ResponseEntity.ok().body(listLocacaoFromRepository);
    }


    @PostMapping
    public ResponseEntity<Locacao> insertlocacao(@RequestBody Locacao locacao){
        locacao = locacaoServices.insertLocacaoFromRepository(locacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(locacao.getId())
                .toUri();
        return ResponseEntity.created(uri).body(locacao);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        locacaoServices.deleteLocacaoById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Locacao> update(@PathVariable Long id, @RequestBody Locacao locacao){
        locacao = locacaoServices.update(id,locacao);
        return ResponseEntity.ok().body(locacao);
    }



}
