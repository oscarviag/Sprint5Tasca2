package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.services;

import java.util.List;

import org.springframework.stereotype.Service;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Partida;

@Service
public interface IPartidaService {

	List<Partida> getOneJugador(int id);

	List<Partida> getAllPartides();
	
	void deletePartida(int id);
	
	public Partida addTirada(int id);

}
