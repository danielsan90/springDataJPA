package com.example.springBootHibernate.service;

import com.example.springBootHibernate.model.Giocatore;

import java.util.List;
import java.util.Optional;

public interface IGiocatoreService {

    public List<Giocatore> getGiocatori();

    public Giocatore getById(Long id);

    public void updateGiocatore(Giocatore g);

    public void deleteGiocatore(Long id);

    public Giocatore saveGiocatore(Giocatore g);
}
