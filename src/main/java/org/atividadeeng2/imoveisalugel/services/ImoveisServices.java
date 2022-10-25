package org.atividadeeng2.imoveisalugel.services;


import org.atividadeeng2.imoveisalugel.entities.Imoveis;
import org.atividadeeng2.imoveisalugel.repositories.ImoveisRepository;
import org.atividadeeng2.imoveisalugel.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImoveisServices {

    @Autowired
    private ImoveisRepository ImoveisRepository;

    public Imoveis insertImoveisFromRepository(Imoveis Imoveis){
        return ImoveisRepository.save(Imoveis);
    }

    public void insertAllImoveisIntoRepository(List<Imoveis> Imoveiss){
         ImoveisRepository.saveAll(Imoveiss);
    }

    public List<Imoveis> findAllImoveissFromRepository(){
        return ImoveisRepository.findAll();
    }

    public Imoveis findImoveisByIdFromRepository(Long id){
       Optional<Imoveis> ImoveisToUpdate = ImoveisRepository.findById(id);
       return ImoveisToUpdate.orElseThrow(()-> new ResouceNotFoundException(id));

    }

    public Imoveis update(Long id, Imoveis ImoveisUpdated){
        Imoveis ImoveisToUpdate = ImoveisRepository.getReferenceById(id);
        updateData(ImoveisToUpdate,ImoveisUpdated);
        return ImoveisRepository.save(ImoveisToUpdate);
    }

    private void updateData(Imoveis ImoveisToUpdate, Imoveis ImoveisUpdated) {
        ImoveisToUpdate.setBairro(ImoveisUpdated.getBairro());
        ImoveisToUpdate.setBanheiros(ImoveisUpdated.getBanheiros());
        ImoveisToUpdate.setCep(ImoveisUpdated.getCep());
        ImoveisToUpdate.setObservacao(ImoveisUpdated.getObservacao());
        ImoveisToUpdate.setEndereco(ImoveisUpdated.getEndereco());
        ImoveisToUpdate.setVagasGaragem(ImoveisUpdated.getVagasGaragem());
        ImoveisToUpdate.setValorAluguelSugerido(ImoveisUpdated.getValorAluguelSugerido());
        ImoveisToUpdate.setMetragem(ImoveisUpdated.getMetragem());

    }

    public void deleteImoveisById(Long id){
        ImoveisRepository.deleteById(id);
    }


}
