package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Jugador;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.repository.JugadorRepository;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.services.JugadorService;




@ExtendWith(MockitoExtension.class)
class JugadorServiceTest {

	@Mock
    private JugadorRepository jugadorRepository;

    @InjectMocks
    private JugadorService jugadorService;

    @Test
	public void getAllJugadors()
	{
		List<Jugador> list = new ArrayList<Jugador>();
		Jugador jugadorU = new Jugador("Joan");
		Jugador jugadorDos = new Jugador("Pep");
		Jugador jugadorTres = new Jugador("Ramon");

		list.add(jugadorU);
		list.add(jugadorDos);
		list.add(jugadorTres);

		when(jugadorRepository.findAll()).thenReturn(list);

		List<Jugador> jugadorsList = jugadorService.getTotsJugadors();

		assertEquals(3, jugadorsList.size());
		verify(jugadorRepository, times(1)).findAll();
	}
    
    @Test
	public void crearJugadorTest()
	{
		Jugador jugador = new Jugador(1,"Pep");

		jugadorService.addJugador(jugador);

		verify(jugadorRepository, times(1)).save(jugador);
	}

}

