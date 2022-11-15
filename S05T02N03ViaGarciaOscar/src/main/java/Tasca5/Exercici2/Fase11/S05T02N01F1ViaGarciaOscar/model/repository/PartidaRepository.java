package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Jugador;
import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Partida;


@Repository
@Component
public interface PartidaRepository extends MongoRepository<Partida, Integer>{
		
	@Transactional
	int deleteAllByIdJugador(int id_jugador);
	
	List<Partida> findByIdJugador(int id_jugador);

	Partida save(Partida novaPartida);
		
	@Query("{partides : { $exists: true, $ne: [] }}")
	List<Jugador> findByPartidesExists();
	
	
}
