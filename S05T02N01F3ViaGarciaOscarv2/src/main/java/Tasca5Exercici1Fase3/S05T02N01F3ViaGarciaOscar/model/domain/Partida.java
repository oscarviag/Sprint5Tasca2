package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Table(name="partides")
public class Partida {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Integer idPartida;
				
		@Column(name = "idJugador")
		Integer idJugador;
		
		@Column(name = "dau1")
		Integer dau1;
		
		@Column(name = "dau2")
		Integer dau2;
				
		@ManyToOne
		@JoinColumn(name="idJugador", insertable=false, updatable=false)
		Jugador jugador;
		
		public Partida() {

		}
		
		
		public Partida(Integer idJugador, int dau1, int dau2) {
			super();
			this.idJugador = idJugador;
			this.dau1 = dau1;
			this.dau2 = dau2;
		}
		
		public Partida(Integer idJugador) {
			super();
			this.idJugador = idJugador;
			this.dau1 = TiradaDaus.tirada();
			this.dau2 = TiradaDaus.tirada();
		}

		public Integer getIdJugador() {
			return idJugador;
		}

		public void setIdJugador(Integer idJugador) {
			this.idJugador = idJugador;
		}

		public Integer getDau1() {
			return dau1;
		}

		public void setDau1(Integer dau1) {
			this.dau1 = dau1;
		}

		public Integer getDau2() {
			return dau2;
		}

		public void setDau2(Integer dau2) {
			this.dau2 = dau2;
		}


		@Override
		public String toString() {
			return "Partida [idPartida= "+ idPartida + ", idJugador=" + idJugador + ", dau1=" + dau1 + ", dau2=" + dau2 + "]\n";
		}
		
		

}
