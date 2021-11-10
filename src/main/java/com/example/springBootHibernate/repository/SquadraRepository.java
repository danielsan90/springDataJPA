package com.example.springBootHibernate.repository;

import com.example.springBootHibernate.model.Giocatore;
import com.example.springBootHibernate.model.Squadra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquadraRepository extends JpaRepository<Squadra, Long> {
}
