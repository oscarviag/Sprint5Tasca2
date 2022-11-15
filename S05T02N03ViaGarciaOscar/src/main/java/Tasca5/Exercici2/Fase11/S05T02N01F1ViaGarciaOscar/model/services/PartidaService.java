package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.repository.PartidaRepository;
import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Partida;

@Service
public class PartidaService implements IPartidaService{
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	
	public Partida addTirada(int id) {
		
		Partida novaPartida = new Partida(id);
		
		System.out.println(novaPartida.toString());
		
		return partidaRepository.save(novaPartida);
		
	}
	
	public List<Partida> getOneJugador(int id) {
		
		System.out.println("id enviat "+id);
		List<Partida> llistat = new ArrayList<>();
		llistat = partidaRepository.findByIdJugador(id);
		System.out.println(llistat.toString());
		System.out.println(llistat);
		System.out.println("llistat "+id);
		return llistat;
	}
	
	
	public void deletePartida(int id) {
		
		partidaRepository.deleteAllByIdJugador(id);
		
		
	}

	public List<Partida> getAllPartides() {
		
		List<Partida> llistat = new ArrayList<>(partidaRepository.findAll());
				
		for(Partida entitat:llistat) {	
			
			System.out.println(entitat.toString());
		}
		
		return llistat;
	}
	

}
