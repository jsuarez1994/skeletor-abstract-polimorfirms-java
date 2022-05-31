package es.santander.ucrapl.mcs.repository;

import org.springframework.stereotype.Repository;

import es.santander.ucrapl.mcs.documents.ExampleDocument;

/**
 * Repositorio de tabla table_example
 * 
 * @author jslopez
 */
@Repository("exampleRepository")
public interface ExampleRepository extends BaseRepository<ExampleDocument> {
}
