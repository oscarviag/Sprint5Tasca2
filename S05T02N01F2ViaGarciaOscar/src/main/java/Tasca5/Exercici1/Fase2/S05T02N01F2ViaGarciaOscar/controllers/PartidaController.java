package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Jugador;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Partida;
/*import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.repository.JugadorRepository;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services.GeneradorSequenciaService;*/
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services.IJugadorService;


@CrossOrigin(origins = "http://localhost:9000")
@Controller
public class PartidaController {
	

	@Autowired
	private IJugadorService jugadorService;
	
	@PostMapping("/players/{id}/games/")
	public ResponseEntity<String> addPartida(@PathVariable Integer id) {
			
		try {
						
			Jugador nouJugador = jugadorService.getJugadorExisteix(id);
			System.out.println("El jugador "+id+" existeix es juga la partida");
			System.out.println(nouJugador);

					
			Partida novaPartida = new Partida(id);
			
			ArrayList<Partida> totesPartides = nouJugador.getPartides();			
			totesPartides.add(novaPartida);		
			nouJugador.setPartides(totesPartides);
			
			double mitjana;
			double exits = 0;
						
			for (Partida partida:totesPartides) {				
				 if ((partida.getDau1()+partida.getDau2()) == 7) exits++;
			}
				
				int partidesTotals = totesPartides.size();
				
				mitjana = (exits/partidesTotals*100);
				
				nouJugador.setPercentatgeExit(mitjana);
				
				System.out.println(nouJugador);
				
				jugadorService.updatePercentatges(nouJugador);
					
			return new ResponseEntity<>(novaPartida.toString(), HttpStatus.CREATED);
			
		
		} catch (Exception e) {
			
			return new ResponseEntity<>("Aquest index no existeix, no es pot fer la partida", HttpStatus.INTERNAL_SERVER_ERROR);		
		}

	}
	
	@DeleteMapping("/players/{id}/games/")
	public ResponseEntity<String> delete(@PathVariable int id) {
		
		try {
			
			jugadorService.deletePartida(id);
			
			return new ResponseEntity<>("Partides esborrades", HttpStatus.CREATED);
		}
		catch (Exception e) { 
		
			return new ResponseEntity<>("Aquest jugador no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
				
		}
	}

	
	@GetMapping("/players/{id}/games/")
	public ResponseEntity<String> getOneJugador(@PathVariable int id) {
		
		try {
			
			ArrayList<Partida> partidesJugador = (ArrayList<Partida>) jugadorService.getOneJugador(id);
			
			return new ResponseEntity<>(partidesJugador.toString(), HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Aquest index no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
		
	
	@GetMapping("/players/ranking")
	public ResponseEntity<String> getAllPartides() {

			List<Jugador> totesPartides = jugadorService.getAllPartides();
			double mitjana;
			double exits = 0;
			double partidesJugades=0;
			
			if (!totesPartides.isEmpty()) {
				
				
				
				for (Jugador jugador:totesPartides) {
					
					for (Partida partida:jugador.getPartides()) {
							partidesJugades++;
							if ((partida.getDau1()+partida.getDau2()) == 7) exits++;
					}
				}
				
				mitjana = (exits/partidesJugades*100);
							
				return new ResponseEntity<>("Mitjana d'??xit: " + String.format("%.2f", mitjana) + " %", HttpStatus.CREATED);	}		
			else 
				return new ResponseEntity<>("No existeixen partides", HttpStatus.INTERNAL_SERVER_ERROR);

	}
		
	
}
