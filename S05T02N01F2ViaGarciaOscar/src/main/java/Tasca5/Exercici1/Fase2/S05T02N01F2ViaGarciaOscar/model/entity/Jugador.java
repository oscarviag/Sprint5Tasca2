package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity;



import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;



import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="jugadors")
public class Jugador {
	
	@Transient
    public static final String SEQUENCE_NAME = "jugador_sequencia";
	
	@Id
	int id;
	String nomJugador;
	private Date dataRegistre= Date.from(Instant.now());
	Double percentatgeExit=00.00;
	ArrayList<Partida> partides = new ArrayList<>();
	
	public Jugador() {
		super();
		partides=new ArrayList<Partida>();

	}
	
	public Jugador(Integer idJugador, String nomJugador) {
		super();
		this.id = idJugador;
		this.nomJugador = nomJugador;
	};
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer idJugador) {
		this.id = idJugador;
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
	
	

	public ArrayList<Partida> getPartides() {
		return partides;
	}

	public void setPartides(ArrayList<Partida> partides) {
		this.partides = partides;
	}

	@Override
	public String toString() {
		return " idJugador=" + id + ", nomJugador=" + nomJugador + ", percentatge èxit= " + String.format("%.2f", percentatgeExit) +" %, data registre= " + dataRegistre + "]\n";
	}

	public Date getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(Date dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

}
