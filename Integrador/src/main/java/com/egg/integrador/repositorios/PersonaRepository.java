package com.egg.integrador.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.integrador.Cancha;
import com.egg.integrador.Persona;


@Repository("personaRepository")
public interface PersonaRepository extends JpaRepository<Persona, Integer>{

}
