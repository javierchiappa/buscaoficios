package com.egg.integrador;

import java.util.Random;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Cancha {
	@Id
	@GeneratedValue
	private Integer idCancha;

	private String ciudad;
	
	private String nombre;
	
	
	@OneToMany
	Set<Reserva> reservas;
	
	public Cancha() {
	}

	public Cancha(String ciudad) {
		Random ale = new Random();

		this.ciudad = ciudad;
		this.idCancha = ale.nextInt(100000);
	}

	public void addReserva(Reserva nueva) {
		boolean ocupada = false;
		for (Reserva res : reservas) {
			if (res.getFechaReserva().equals(nueva.getFechaReserva())) {
				ocupada = true;
			}
		}
		if (ocupada == true) {
			System.out.println(
					"la cancha " + this.getIdCancha() + "esta ocupada en el horario " + nueva.getFechaReserva());
		} else {
			reservas.add(nueva);
		}
	}

	public Integer getIdCancha() {
		return idCancha;
	}

	public void setIdCancha(Integer idCancha) {
		this.idCancha = idCancha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
