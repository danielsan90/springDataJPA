package com.example.springBootHibernate.repository;

import com.example.springBootHibernate.model.Giocatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GiocatoreRepository extends JpaRepository<Giocatore, Long> {

    //@Query("SELECT g FROM Giocatore  g WHERE g.squadra.id  = ?1")
    public List<Giocatore> findBySquadraId(Long idSquadra);
    /*
    Spring Data JPA internally provides @Repository annotation
    so we no need to add @Repository annotation
         */

    // https://www.youtube.com/watch?v=IucFDX3RO9U&ab_channel=JavaTechie  <- presa da qui

    //https://www.youtube.com/watch?v=4Ico2HjRTCE&ab_channel=JavaGuides  <- + completa
}
