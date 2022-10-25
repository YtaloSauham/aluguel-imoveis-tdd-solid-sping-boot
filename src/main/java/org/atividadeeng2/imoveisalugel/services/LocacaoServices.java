package org.atividadeeng2.imoveisalugel.services;


import org.atividadeeng2.imoveisalugel.entities.Locacao;
import org.atividadeeng2.imoveisalugel.repositories.LocacaoRepository;
import org.atividadeeng2.imoveisalugel.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoServices {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public Locacao insertLocacaoFromRepository(Locacao locacao){
        return locacaoRepository.save(locacao);
    }

    public void insertAllLocacaoIntoRepository(List<Locacao> Locacaos){
         locacaoRepository.saveAll(Locacaos);
    }

    public List<Locacao> findAllLocacaosFromRepository(){
        return locacaoRepository.findAll();
    }

    public Locacao findLocacaoByIdFromRepository(Long id){
       Optional<Locacao> LocacaoToUpdate = locacaoRepository.findById(id);
       return LocacaoToUpdate.orElseThrow(()-> new ResouceNotFoundException(id));

    }

    public Locacao update(Long id, Locacao LocacaoUpdated){
        Locacao LocacaoToUpdate = locacaoRepository.getReferenceById(id);
        updateData(LocacaoToUpdate,LocacaoUpdated);
        return locacaoRepository.save(LocacaoToUpdate);
    }

    private void updateData(Locacao LocacaoToUpdate, Locacao LocacaoUpdated) {
        LocacaoToUpdate.setAtivo(LocacaoUpdated.getAtivo());
        LocacaoToUpdate.setDataInicio(LocacaoUpdated.getDataInicio());
        LocacaoToUpdate.setDataFim(LocacaoUpdated.getDataFim());
        LocacaoToUpdate.setObservacao(LocacaoUpdated.getObservacao());
        LocacaoToUpdate.setDiaVencimento(LocacaoUpdated.getDiaVencimento());
        LocacaoToUpdate.setPercentualMultal(LocacaoUpdated.getPercentualMultal());
        LocacaoToUpdate.setInquilino(LocacaoUpdated.getInquilino());
        LocacaoToUpdate.setImovel(LocacaoUpdated.getImovel());

    }

    public void deleteLocacaoById(Long id){
        locacaoRepository.deleteById(id);
    }


}
