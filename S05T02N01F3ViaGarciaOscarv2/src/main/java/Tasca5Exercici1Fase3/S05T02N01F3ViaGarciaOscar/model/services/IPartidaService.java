package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Partida;



@Service
public interface IPartidaService {

	List<Partida> getOneJugador(int id);

	List<Partida> getAllPartides();
	
	void deletePartida(int id);
	
	public Partida addTirada(int id);

}
