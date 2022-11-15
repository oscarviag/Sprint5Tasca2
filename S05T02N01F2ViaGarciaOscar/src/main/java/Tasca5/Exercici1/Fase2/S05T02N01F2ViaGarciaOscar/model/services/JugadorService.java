package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Jugador;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Partida;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.repository.JugadorRepository;


@Service
public class JugadorService implements IJugadorService{
	
	@Autowired
	private JugadorRepository jugadorRepository;
	
	
	public Jugador addJugador(Jugador jugador) {
		
		System.out.println("nom jugador " + jugador.getNomJugador());
		
		if (jugador.getNomJugador()==null) {
			
			jugador.setNomJugador("ANÒNIM");
			
			jugadorRepository.save(jugador);	
			
			System.out.println("Jugador anònim gravat ");
			return jugador;
			
		}
		else {
			
			try {
				
				if (!jugadorRepository.existsByNomJugador(jugador.getNomJugador())) {
					
					jugadorRepository.save(jugador);
					
					System.out.println("Nou jugador "+ jugador.getNomJugador() + " gravat");
					return jugador;
					
				} else { 
					
					jugador.setId(0);
					System.out.println("El jugador ja existeix");
					return jugador;
					
				}
				
			}
			
			catch (Exception ex){
				
				System.out.println("ERROR: " + ex.getMessage());
			}
			
		}
		
		return null;
		
	}
	
	public Jugador updateJugador(Jugador jugador) {

	
		Optional<Jugador> jugadorExisteix = jugadorRepository.findById(jugador.getId());
		
		
		System.out.println("nom del jugador d'aquest id " + jugadorExisteix.get().getNomJugador().toString());
		
		Jugador jugadorActualitzat = null;
		
		if (jugadorExisteix.isPresent() && !jugadorRepository.existsByNomJugador(jugador.getNomJugador())) {			
			jugadorActualitzat = jugadorExisteix.get();
			jugadorActualitzat.setNomJugador(jugador.getNomJugador());
			jugadorRepository.save(jugadorActualitzat);
			
		} else {
			
			jugadorActualitzat = new Jugador();
			jugadorActualitzat.setId(0);
		}
		
		return jugadorActualitzat;
			
	}
	
	public void updatePercentatges(Jugador jugador) {
		
		jugadorRepository.save(jugador);

			
	}	
		
	public List<Jugador> getTotsJugadors() {
		
		List<Jugador> llistat = new ArrayList<>(jugadorRepository.findAll());
		
		return llistat;
	}
		
	public Partida getOneJugador(Integer id) {
				
		return null;
	}
	
	public String deleteJugador(int id) {
		
		jugadorRepository.deleteById(id);
		
		return "Jugador esborrat";
		
	}

	@Override
	public Jugador getJugadorExisteix(Integer id) {
		
		Jugador jugadorExisteix = jugadorRepository.findById(id).orElse(null);
		System.out.println(jugadorExisteix);

		return jugadorExisteix;
	}
	


	@Override
	public Jugador getLoser() {		
		List<Jugador> jugador = jugadorRepository.findLoserJugadorByPercentatgeExit();		
		return jugador.get(0);
	}

	@Override
	public Jugador getWinner() {
		
		List<Jugador> jugador = jugadorRepository.findWinnerJugadorByPercentatgeExit();	
		return jugador.get(0);
		
		
	}
	
	public Partida addTirada(int id) {		
		Partida novaPartida = new Partida(id);		
		System.out.println(novaPartida.toString());		
		return jugadorRepository.save(novaPartida);
		
	}
	
	public List<Partida> getOneJugador(int id) {
		
		System.out.println("id enviat "+id);
		Optional<Jugador> jugadorLlistat = jugadorRepository.findById(id);
		
		if (jugadorLlistat.isPresent()) {
			
			Jugador jugador = jugadorLlistat.get();
			
			ArrayList<Partida> llistat =jugador.getPartides();
			
			return llistat;
		} else {
			
			return null;
		}
		
}
	
	
	public void deletePartida(int id) {
		
		Optional<Jugador> jugadorEsborra = jugadorRepository.findById(id);
				
		if (jugadorEsborra.isPresent()) {
			
			Jugador jugador = jugadorEsborra.get();		
			jugador.setPartides(new ArrayList<Partida>());		
			jugadorRepository.save(jugador);
		};	
	}
	

	public List<Jugador> getAllPartides() {
		
		List<Jugador> llistat = new ArrayList<Jugador>();	
		
		llistat = jugadorRepository.findByPartidesExists();
		
		for(Jugador entitat:llistat) {	
			
			System.out.println(entitat.toString());
		}
		
		return llistat;
	}



	
}
