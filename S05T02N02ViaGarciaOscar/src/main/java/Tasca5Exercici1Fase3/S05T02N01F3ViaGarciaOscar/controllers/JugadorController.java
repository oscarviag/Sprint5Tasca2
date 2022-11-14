package Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.controllers;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.domain.Jugador;
import Tasca5Exercici1Fase3.S05T02N01F3ViaGarciaOscar.model.services.IJugadorService;






@CrossOrigin(origins = "http://localhost:9000")
@Controller
public class JugadorController {
	
	@Autowired
	private IJugadorService jugadorService;
	
	@PostMapping("/players")
	public ResponseEntity<String> addJugador(@RequestBody(required = false) Jugador jugador) {
		
		if (jugador==null) {
			jugador = new Jugador();
		}
				Jugador nouJugador = jugadorService.addJugador(jugador);
				
				if (nouJugador.getIdJugador()!=0 )
					
					return new ResponseEntity<>(nouJugador.toString() + "Afegit a la BD\n", HttpStatus.CREATED);
				
				else 
				
					return new ResponseEntity<>("No s'ha pogut crear el jugador a la BD, pot ser que ja existeixi", HttpStatus.INTERNAL_SERVER_ERROR);
		

	}
	
	@PutMapping("/players")
	public ResponseEntity<String> updateJugador(@RequestBody Jugador jugador) {
				
			Jugador jugadorActualitzat = jugadorService.updateJugador(jugador);
			
			if (jugadorActualitzat.getIdJugador() != 0)
				
				return new ResponseEntity<>(jugadorActualitzat.toString() + " Jugador actualitzat", HttpStatus.CREATED);
			
			else 
			
				return new ResponseEntity<>("Aquest nom ja existeix a la BD", HttpStatus.INTERNAL_SERVER_ERROR);
					
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

		List<Jugador> llistat = jugadorService.getLoser();
		System.out.println(llistat);
			
			if (llistat!=null) 
				return new ResponseEntity<>(llistat.get(0).toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen jugadors", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/players/ranking/winner")
	public ResponseEntity<String> getWinner() {

		List<Jugador> llistat = jugadorService.getWinner();
		System.out.println(llistat);
			
			if (llistat!=null) 
				return new ResponseEntity<>(llistat.get(0).toString(), HttpStatus.CREATED);			
			else 
				return new ResponseEntity<>("No existeixen jugadors", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
}
