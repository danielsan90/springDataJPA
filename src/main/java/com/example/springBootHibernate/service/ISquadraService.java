package com.example.springBootHibernate.service;

import com.example.springBootHibernate.model.Squadra;

import java.util.List;

public interface ISquadraService {

    public List<Squadra> getSquadre();

    public Squadra getById(Long id);

    public Squadra updateSquadra(Squadra g);

    public void deleteSquadra(Long id);

    public Squadra saveSquadra(Squadra g);
}
