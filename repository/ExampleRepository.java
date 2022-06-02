package repository;

import org.springframework.stereotype.Repository;

import documents.ExampleDocument;

/**
 * Repositorio de tabla table_example
 * 
 * @author jslopez
 */
@Repository("exampleRepository")
public interface ExampleRepository extends BaseRepository<ExampleDocument> {
}
