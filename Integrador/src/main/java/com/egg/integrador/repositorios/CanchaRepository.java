package com.egg.integrador.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.egg.integrador.Cancha;


@Repository("canchaRepository")
public interface CanchaRepository extends JpaRepository<Cancha, Integer>{

}
