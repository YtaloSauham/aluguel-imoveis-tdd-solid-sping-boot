package org.atividadeeng2.imoveisalugel.services;


import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.repositories.AluguelRepository;
import org.atividadeeng2.imoveisalugel.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelServices {

    @Autowired
    private AluguelRepository AluguelRepository;

    public Aluguel insertAluguelFromRepository(Aluguel Aluguel){
        return AluguelRepository.save(Aluguel);
    }

    public void insertAllAluguelsIntoRepository(List<Aluguel> Aluguels){
         AluguelRepository.saveAll(Aluguels);
    }

    public List<Aluguel> findAllAluguelsFromRepository(){
        return AluguelRepository.findAll();
    }

    public Aluguel findAluguelByIdFromRepository(Long id){
       Optional<Aluguel> AluguelToUpdate = AluguelRepository.findById(id);
       return AluguelToUpdate.orElseThrow(()-> new ResouceNotFoundException(id));

    }

    public Aluguel update(Long id, Aluguel AluguelUpdated){
        Aluguel AluguelToUpdate = AluguelRepository.getReferenceById(id);
        updateData(AluguelToUpdate,AluguelUpdated);
        return AluguelRepository.save(AluguelToUpdate);
    }

    private void updateData(Aluguel AluguelToUpdate, Aluguel AluguelUpdated) {
        AluguelToUpdate.setDataPagamento(AluguelUpdated.getDataPagamento());
        AluguelToUpdate.setDataVencimento(AluguelUpdated.getDataVencimento());
        AluguelToUpdate.setValorPago(AluguelUpdated.getValorPago());
        AluguelToUpdate.setObservacao(AluguelUpdated.getObservacao());

    }

    public void deleteAluguelById(Long id){
        AluguelRepository.deleteById(id);
    }


}
