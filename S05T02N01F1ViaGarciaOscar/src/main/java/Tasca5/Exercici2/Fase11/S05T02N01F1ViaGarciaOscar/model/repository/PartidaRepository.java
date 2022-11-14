package Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Tasca5.Exercici2.Fase11.S05T02N01F1ViaGarciaOscar.model.domain.Partida;


@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer>{
	
	@Transactional
	int deleteByIdJugadorIs(int id_jugador);
	
	List<Partida> findByIdJugadorIs(int id_jugador);
	
	
}
