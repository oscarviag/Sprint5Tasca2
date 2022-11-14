package Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.services;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import Tasca5.Exercici1.Fase2.S05T02N01F2ViaGarciaOscar.model.entity.SequenciaId;


@Service
public class GeneradorSequenciaService {
		
	 private MongoOperations mongoOperations;

	 @Autowired
	 public GeneradorSequenciaService(MongoOperations mongoOperations) {
	        this.mongoOperations = mongoOperations;
	 }

	 public int generarSequencia(String seqName) {

	 SequenciaId comptador = mongoOperations.findAndModify(new Query(where("id").is(seqName)),
	          new Update().inc("sequencia",1), options().returnNew(true).upsert(true),
	          SequenciaId.class);
	 return !Objects.isNull(comptador) ? comptador.getSequencia() : 1;

	    }


		
	
}
