package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Jugador;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository.JugadorRepository;


@SpringBootTest
class JugadorRepositoryTests {

	 
	    @Autowired
	    private JugadorRepository jugadorRepository;
	     
	    @Test
	    void millorPercentatge() {
	        Jugador jugador1 = new Jugador("Ruben");
	        Jugador jugador2 = new Jugador("Pep");
	        Jugador jugador3 = new Jugador("Jordi");
	        jugador1.setPercentatgeExit(95.70);
	        jugador2.setPercentatgeExit(35.80);
	        jugador3.setPercentatgeExit(95.70);
	        
	        jugadorRepository.save(jugador2);
	        jugadorRepository.save(jugador3);
	        jugadorRepository.save(jugador1);
	        assertThat(jugadorRepository.winner()).hasSize(2);	        	    
	    }
	    
	    @Test
	    void jugadorExisteixPerId() {
	        Jugador jugador = new Jugador("Ruben");
	        jugadorRepository.save(jugador);
	        Boolean actualResult = jugadorRepository.existsByNomJugador("Ruben");
	        assertThat(actualResult).isTrue();
	    
	    }

}




    




