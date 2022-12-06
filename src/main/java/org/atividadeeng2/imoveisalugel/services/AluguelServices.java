package org.atividadeeng2.imoveisalugel.services;


import org.atividadeeng2.imoveisalugel.entities.Aluguel;
import org.atividadeeng2.imoveisalugel.entities.Email;
import org.atividadeeng2.imoveisalugel.entities.Locacao;
import org.atividadeeng2.imoveisalugel.entities.User;
import org.atividadeeng2.imoveisalugel.repositories.AluguelRepository;
import org.atividadeeng2.imoveisalugel.services.exceptions.ResouceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelServices {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private LocacaoServices localServices;

    public Aluguel insertAluguelFromRepository(Aluguel Aluguel){
        return aluguelRepository.save(Aluguel);
    }

    public void insertAllAluguelsIntoRepository(List<Aluguel> Aluguels){
         aluguelRepository.saveAll(Aluguels);
    }

    public List<Aluguel> findAllAluguelsFromRepository(){
        return aluguelRepository.findAll();
    }

    public Aluguel findAluguelByIdFromRepository(Long id){
       Optional<Aluguel> aluguelToUpdate = aluguelRepository.findById(id);
       return aluguelToUpdate.orElseThrow(()-> new ResouceNotFoundException(id));

    }

    public Aluguel update(Long id, Aluguel aluguelUpdated){
        Aluguel aluguelToUpdate = aluguelRepository.getReferenceById(id);
        updateData(aluguelToUpdate,aluguelUpdated);
        return aluguelRepository.save(aluguelToUpdate);
    }

    private void updateData(Aluguel aluguelToUpdate, Aluguel aluguelUpdated) {
        aluguelToUpdate.setDataPagamento(aluguelUpdated.getDataPagamento());
        aluguelToUpdate.setDataVencimento(aluguelUpdated.getDataVencimento());
        aluguelToUpdate.setValorPago(aluguelUpdated.getValorPago());
        aluguelToUpdate.setObservacao(aluguelUpdated.getObservacao());

    }

    public void deleteAluguelById(Long id){
        aluguelRepository.deleteById(id);
    }

    public Aluguel payRent(Long id, Double valor){
        Aluguel aluguelFind = aluguelRepository.getReferenceById(id);
        aluguelFind.setDataPagamento(LocalDate.now());
        aluguelFind.setValorPago(valor);
        return aluguelRepository.save(aluguelFind);
    }

    public List<User> findAllUsersWhoHaveNotPaid(){

        List<Aluguel> listAluguelWhoHaveNotPaid= aluguelRepository.findByPayment(null);
        List<Locacao> listLocacaoUsersWhoHaveNotPaid = localServices.findByAluguel(listAluguelWhoHaveNotPaid);
        List<User> listUsersWhoHaveNotPaid = new ArrayList<User>() ;
        for(Locacao locacao: listLocacaoUsersWhoHaveNotPaid){
            listUsersWhoHaveNotPaid.add(locacao.getInquilino());
        }

        return listUsersWhoHaveNotPaid;
    }

    public List<Aluguel> findAluguelByPayment(Float valorPago){
        List<Aluguel> aluguelList = aluguelRepository.findByPayment(valorPago);
        return aluguelList;
    }

    public void sendAnEmailToUsersWhoHaveNotPaid(){
        List<User> userList = findAllUsersWhoHaveNotPaid();
        Email sendEmail= new Email() ;
        for(User users: userList){
            sendEmail.send( "Devendo", users.getEmail(), "Você ainda não realizou o pagamento");
        }




    }




}
