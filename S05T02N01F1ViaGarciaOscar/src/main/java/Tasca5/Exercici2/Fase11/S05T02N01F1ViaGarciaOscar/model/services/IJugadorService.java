package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Jugador;


@Service
public interface IJugadorService {
	
	public Jugador addJugador(Jugador jugador);
	
	public Jugador updateJugador(Jugador jugador);
	
	public List<Jugador> getTotsJugadors();
	
	public String deleteJugador(int id);
	
	public Jugador getJugadorExisteix(Integer id);
	
	public List<Jugador> getLoser();

	public List<Jugador> getWinner();

	public void updatePercentatges(Jugador jugador);
	
	
	
	

	


}
