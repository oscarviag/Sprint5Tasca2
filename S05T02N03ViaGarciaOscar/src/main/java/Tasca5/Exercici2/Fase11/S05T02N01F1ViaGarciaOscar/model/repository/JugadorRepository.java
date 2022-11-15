package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Jugador;


@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer>{
	
	
	@Query(value = "SELECT * FROM Jugadors WHERE (percentatge = (SELECT MIN(percentatge) FROM Jugadors ))", nativeQuery=true)
	List<Jugador> loser();
	
	@Query(value = "SELECT * FROM Jugadors WHERE (percentatge = (SELECT MAX(percentatge) FROM Jugadors ))", nativeQuery=true)
	List<Jugador> winner();
	
	boolean existsByNomJugador(String nomJugador);
	
}
