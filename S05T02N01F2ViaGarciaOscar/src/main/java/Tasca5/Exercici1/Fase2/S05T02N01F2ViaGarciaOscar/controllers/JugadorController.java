package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Jugador;
//import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.repository.JugadorRepository;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services.GeneradorSequenciaService;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services.IJugadorService;



@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private GeneradorSequenciaService serveiGeneradorId;
	
	@PostMapping("/players")
	public ResponseEntity<String> addJugador(@RequestBody(required = false) Jugador jugador) {
		
				if (jugador==null) {
					jugador = new Jugador();
				} 
		
				jugador.setId(serveiGeneradorId.generarSequencia(Jugador.SEQUENCE_NAME));
				System.out.println("creem id "+ jugador.getId());
				
				Jugador nouJugador = jugadorService.addJugador(jugador);
				
				if (nouJugador.getId()!=0 )
					
					return new ResponseEntity<>(nouJugador.toString() + "Afegit a la BD\n", HttpStatus.CREATED);
				
				else 
				
					return new ResponseEntity<>("No s'ha pogut crear el jugador a la BD, pot ser que ja existeixi", HttpStatus.INTERNAL_SERVER_ERROR);
		

	}
	
	@PutMapping("/players")
	public ResponseEntity<String> updateJugador(@RequestBody Jugador jugador) {
				
			Jugador jugadorActualitzat = jugadorService.updateJugador(jugador);
			
			if (jugadorActualitzat.getId() != 0)
				
				return new ResponseEntity<>(jugadorActualitzat.toString() + " Jugador actualitzat", HttpStatus.CREATED);
			
			else 
			
				return new ResponseEntity<>("Aquest nom ja existeix a la BD o bé l'index indicat no existeix", HttpStatus.INTERNAL_SERVER_ERROR);
					
	}
	
	@GetMapping("/players")
	public ResponseEntity<String> getTotsJugadors() {

			List<Jugador> totsJugadors = jugadorService.getTotsJugadors();
			
			if (!totsJugadors.isEmpty()) 
				return new ResponseEntity<>(totsJugadors.toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen jugadors", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/players/ranking/loser")
	public ResponseEntity<String> getLoser() {
		
		Jugador loser = jugadorService.getLoser();
		
		System.out.println(loser);
			
			if (loser!=null) 
				return new ResponseEntity<>(loser.toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen jugadors", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<String> getWinner() {

		Jugador winner = jugadorService.getWinner();
		System.out.println(winner);
			
			if (winner!=null) 
				return new ResponseEntity<>(winner.toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen jugadors", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

	
	
}
