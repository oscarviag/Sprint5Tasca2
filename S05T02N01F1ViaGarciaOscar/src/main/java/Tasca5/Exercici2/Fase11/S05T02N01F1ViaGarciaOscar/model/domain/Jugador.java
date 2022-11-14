package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import javax.persistence.GenerationType;

@Entity
@Table(name="jugadors")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idJugador;
	
	@Column(name = "nom")
	String nomJugador;
	
	@Column(name="data_registre")
	private LocalDate dataRegistre= LocalDate.now();
	
	@Column(name = "percentatge", columnDefinition="Decimal(4,2) default '00.00'")
	Double percentatgeExit=00.00;
	
	@OneToMany(mappedBy = "jugador")
	List<Partida> resultats;
	
	public Jugador() {
		super();
		resultats=new ArrayList<Partida>();

	}
	
	public Jugador(Integer idJugador, String nomJugador) {
		super();
		this.idJugador = idJugador;
		this.nomJugador = nomJugador;
	};
	
	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public String getNomJugador() {
		return nomJugador;
	}

	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}
	

	public Double getPercentatgeExit() {
		return percentatgeExit;
	}

	public void setPercentatgeExit(Double percentatgeExit) {
		this.percentatgeExit = percentatgeExit;
	}

	@Override
	public String toString() {
		return "Jugador [idJugador=" + idJugador + ", nomJugador=" + nomJugador + ", percentatge èxit= "+ String.format("%.2f", percentatgeExit) +" %, data registre= " + dataRegistre + "]\n";
	}

	
	
	

}
