package com.egg.integrador;

import java.util.Date;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
	@Id
	@GeneratedValue
	private Integer idReserva;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaReserva;
	
	@ManyToOne
	@JoinColumn(name="equipo1_id")
	private Equipo equipo1;
	
	@ManyToOne
	@JoinColumn(name="equipo2_id")
	private Equipo equipo2;
	
	@ManyToOne
	private Cancha cancha;
	

	public Reserva() {

	}

	public Reserva(Date dReserva, Equipo dEquipo1, Equipo dEquipo2) {
		this.fechaReserva = dReserva;
		this.equipo1 = dEquipo1;
		this.equipo2 = dEquipo2;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	private void addCancha(Cancha cancha) {

	}

	public boolean realizarReserva(Date fecha, Cancha cancha, Equipo e1, Equipo e2) {
		if (!hayJugadoresRepetidos(e1, e2)) {
			Reserva nueva = new Reserva();
			nueva.setFechaReserva(fecha);
			nueva.setEquipo1(e1);
			nueva.setEquipo2(e2);
			cancha.addReserva(nueva);
			this.addCancha(cancha);
			return true;
		} else {
			return false;
		}

	}

	private boolean hayJugadoresRepetidos(Equipo e1, Equipo e2) {

		for (Persona jugador1 : e1.getJugadores()) {
			for (Persona jugador2 : e2.getJugadores())
				if (jugador1.equals(jugador2)) {
					return true;
				}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Reserva [fechaReserva=" + fechaReserva + ", equipo1=" + equipo1 + ", equipo2=" + equipo2
				+ ", idReserva=" + idReserva + "]";
	}

}
