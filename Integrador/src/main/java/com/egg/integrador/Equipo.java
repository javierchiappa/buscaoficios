package com.egg.integrador;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Equipo {
	@Id
	@GeneratedValue
	private Integer equipo_id;
	
	private String nombre;
	
	@ManyToMany
	private List<Persona> jugadores;
	
	
	private int max_Jugadores;

	public Equipo() {
	}
	public Equipo(String name, int jugadores) {
		this.nombre = name;
		this.max_Jugadores = jugadores;
	}

	public void addJugador(Persona jugador) {
		if (jugadores.size() < max_Jugadores) {
		this.jugadores.add(jugador);
		} else {
			System.out.println("Lista completa");
		}
	}
	
	public void removeJugador(String jugador) {
		jugadores.remove(jugador);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Persona> getJugadores() {
		return this.jugadores;
	}

	public void setJugadores(List<Persona> jugadores) {
		this.jugadores = jugadores;
	}

	public int getMax_Jugadores() {
		return max_Jugadores;
	}

	public void setMax_Jugadores(int max_Jugadores) {
		this.max_Jugadores = max_Jugadores;
	}

	
}
