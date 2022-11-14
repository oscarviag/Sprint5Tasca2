package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Jugador;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Partida;


@Service
public interface IJugadorService {
	
	public Jugador addJugador(Jugador jugador);
	
	public Jugador updateJugador(Jugador jugador);
	
	public List<Jugador> getTotsJugadors();
	
	public String deleteJugador(int id);
	
	public Jugador getJugadorExisteix(Integer id);
	
	public Jugador getLoser();

	public Jugador getWinner();

	public void updatePercentatges(Jugador jugador);
	
	List<Partida> getOneJugador(int id);

	List<Jugador> getAllPartides();
	
	void deletePartida(int id);
	
	public Partida addTirada(int id);
	
}
