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
    private ImoveisRepository imoveisRepository;

    public Imoveis insertImoveisFromRepository(Imoveis Imoveis){
        return imoveisRepository.save(Imoveis);
    }

    public void insertAllImoveisIntoRepository(List<Imoveis> Imoveiss){
         imoveisRepository.saveAll(Imoveiss);
    }

    public List<Imoveis> findAllImoveissFromRepository(){
        return imoveisRepository.findAll();
    }

    public Imoveis findImoveisByIdFromRepository(Long id){
       Optional<Imoveis> imoveisToUpdate = imoveisRepository.findById(id);
       return imoveisToUpdate.orElseThrow(()-> new ResouceNotFoundException(id));

    }

    public Imoveis update(Long id, Imoveis imoveisUpdated){
        Imoveis ImoveisToUpdate = imoveisRepository.getReferenceById(id);
        updateData(ImoveisToUpdate,imoveisUpdated);
        return imoveisRepository.save(ImoveisToUpdate);
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
        imoveisRepository.deleteById(id);
    }

    public List<Imoveis> findImoveisByBairroFromRepository(String bairro){
        List<Imoveis> imoveisList =imoveisRepository.findByBairro(bairro);
        return imoveisList;

    }

}
