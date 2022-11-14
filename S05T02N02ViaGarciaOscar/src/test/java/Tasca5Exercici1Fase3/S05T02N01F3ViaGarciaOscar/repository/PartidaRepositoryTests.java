package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Jugador;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Partida;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository.JugadorRepository;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository.PartidaRepository;

@SpringBootTest
class PartidaRepositoryTests {
	
	@Autowired
	PartidaRepository partidaRepository;
	
	@Autowired
	JugadorRepository jugadorRepository;

	@Test
    public void PartidaRetornaTotes() {
		Jugador jugador = new Jugador(1,"Pepe");
		jugadorRepository.save(jugador);
        Partida partida1 = new Partida(1);
        Partida partida2 = new Partida(1);

        partidaRepository.save(partida1);
        partidaRepository.save(partida2);

        List<Partida> partidaList = partidaRepository.findAll();

        Assertions.assertThat(partidaList).isNotNull();
        Assertions.assertThat(partidaList.size()).isEqualTo(2);
    }

}

