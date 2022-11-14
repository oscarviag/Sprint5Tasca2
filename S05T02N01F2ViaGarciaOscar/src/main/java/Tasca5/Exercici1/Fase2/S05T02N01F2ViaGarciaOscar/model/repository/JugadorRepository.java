package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Jugador;
import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.Partida;


@Repository
@Component
public interface JugadorRepository extends MongoRepository<Jugador, Integer>{

	boolean existsByNomJugador(String nomJugador);

	Optional<Jugador> findById(Integer id);
	
	@Transactional
	int deleteById(int id_jugador);
	
	Optional<Jugador> findById(int id_jugador);

	Partida save(Partida novaPartida);
	
	@Query(value="{}", sort="{percentatgeExit : -1 }")
	List<Jugador> findWinnerJugadorByPercentatgeExit();
	
	@Query(value="{}", sort="{percentatgeExit : 1 }")
	List<Jugador> findLoserJugadorByPercentatgeExit();
		
	@Query("{partides : { $exists: true, $ne: [] }}")
	List<Jugador> findByPartidesExists();
	
}
