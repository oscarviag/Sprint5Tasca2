package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain;



import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;



@Document(collection="partides")
public class Partida {
	
		
		Integer idJugador;
		Integer dau1;
		Integer dau2;
		
		public Partida() {

		}
		
		
		public Partida(Integer idJugador, int dau1, int dau2) {
			super();
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
			return "Partida [idJugador=" + idJugador + ", dau1=" + dau1 + ", dau2=" + dau2 + "]\n";
		}
		
		

}
