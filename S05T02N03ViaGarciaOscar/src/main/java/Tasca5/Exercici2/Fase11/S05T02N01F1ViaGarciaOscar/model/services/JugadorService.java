package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Jugador;
import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.repository.JugadorRepository;

@Service
public class JugadorService implements IJugadorService{
	
	@Autowired
	private JugadorRepository jugadorRepository;
	
	public Jugador addJugador(Jugador jugador) {
		
		//System.out.println(jugador.getNomJugador());
		
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
					
					jugador.setIdJugador(0);
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

	
		Optional<Jugador> jugadorExisteix = jugadorRepository.findById(jugador.getIdJugador());
		
		Jugador jugadorActualitzat = null;
		
		if (jugadorExisteix.isPresent() && !jugadorRepository.existsByNomJugador(jugador.getNomJugador())) {			
			jugadorActualitzat = jugadorExisteix.get();
			jugadorActualitzat.setNomJugador(jugador.getNomJugador());
			jugadorRepository.save(jugadorActualitzat);
			
		} else {
			
			jugadorActualitzat = new Jugador();
			jugadorActualitzat.setIdJugador(0);
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
		
	
	/*public String deleteJugador(int id) {
		
		jugadorRepository.deleteById(id);
		
		return "Jugador esborrat";
		
	}*/

	@Override
	public Jugador getJugadorExisteix(Integer id) {
		
		Jugador jugadorExisteix = jugadorRepository.findById(id).orElse(null);
		
		return jugadorExisteix;
	}

	@Override
	public List<Jugador> getLoser() {
		
		List<Jugador> llistat = new ArrayList<>(jugadorRepository.loser());
		
		return llistat;
	}

	@Override
	public List<Jugador> getWinner() {
		
				
		List<Jugador> llistat = new ArrayList<>(jugadorRepository.winner());

		
		return  llistat;
	}

	
}
