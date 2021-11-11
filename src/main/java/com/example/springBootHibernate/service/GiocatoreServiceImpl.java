package com.example.springBootHibernate.service;

import com.example.springBootHibernate.exception.ResourceNotFoundException;
import com.example.springBootHibernate.model.Giocatore;
import com.example.springBootHibernate.model.Squadra;
import com.example.springBootHibernate.repository.GiocatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/*
this is the bean
 */
@Service
public class GiocatoreServiceImpl implements IGiocatoreService{

    @Autowired
    GiocatoreRepository giocatoreRepository;

    @Override
    public List<Giocatore> getGiocatori(){
        List<Giocatore> list= giocatoreRepository.findAll();
        if(CollectionUtils.isEmpty(list)){
            throw new ResourceNotFoundException();
        }
        return list;
    }


    public List<Giocatore> getGiocatoriSquadra(Long idSquadra){
        return giocatoreRepository.findBySquadraId(idSquadra);
    }

    @Override
    public Giocatore getById(Long id) {
        Optional<Giocatore> giocatore = Optional.of(giocatoreRepository.findById(id).get());
        if(giocatore.isPresent()){
            return giocatore.get();
        }else{
            throw new ResourceNotFoundException("giocatore","id", id);
        }
    }

    @Override
    public void updateGiocatore(Giocatore g) {

    }

    @Override
    public void deleteGiocatore(Long id) {
        Giocatore g= Optional.ofNullable(giocatoreRepository.getById(id))
                .orElseThrow(ResourceNotFoundException::new);

          giocatoreRepository.delete(g);
    }

    @Override
    public Giocatore saveGiocatore(Giocatore g) {
        return giocatoreRepository.save(g);
    }


}
