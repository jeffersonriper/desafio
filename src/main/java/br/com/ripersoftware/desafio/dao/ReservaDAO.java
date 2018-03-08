package br.com.ripersoftware.desafio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ripersoftware.desafio.model.Reservas;

public interface ReservaDAO extends JpaRepository<Reservas, Long>{

}
