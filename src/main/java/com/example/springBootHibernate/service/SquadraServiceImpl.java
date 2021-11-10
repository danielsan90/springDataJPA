package com.example.springBootHibernate.service;

import com.example.springBootHibernate.exception.ResourceNotFoundException;
import com.example.springBootHibernate.model.Squadra;
import com.example.springBootHibernate.repository.SquadraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SquadraServiceImpl implements ISquadraService {

    @Autowired
    SquadraRepository squadraRepository;

    @Override
    public List<Squadra> getSquadre() {
        return squadraRepository.findAll();
    }

    @Override
    public Squadra getById(Long id) {
        /*Optional<Squadra> squadra = Optional.of(squadraRepository.findById(id).get());
        if(squadra.isPresent()){
            return squadra.get();
        }else{
            throw new ResourceNotFoundException("squadra","id", id);
        }*/
        Squadra squadra=squadraRepository.findById(id).get();
        if(squadra == null){
            throw new ResourceNotFoundException("squadra","id", id);
        }
        return squadra;



    }

    @Override
    public Squadra updateSquadra(Squadra g) {
        return squadraRepository.save(g);
    }

    @Override
    public void deleteSquadra(Long id) {
         squadraRepository.deleteById(id);
    }

    @Override
    public Squadra saveSquadra(Squadra g) {
        return squadraRepository.save(g);
    }
}
