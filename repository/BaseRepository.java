package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import documents.BaseDocument;

/**
 * Repositorio de tabla base de los tipos
 * 
 * @author jslopez
 *
 * @param <D> the BaseDocument
 */
@Repository
public interface BaseRepository<D extends BaseDocument> extends MongoRepository<D, String> {

	/**
	 * Obtenemos primer elemento por orden systena date, para obtener la fecha
	 * sistema mayor
	 * 
	 * @return List D
	 */
	List<D> findFirstByOrderBySystemDateDesc();

	/**
	 * Obtenemos datos filtrando por system date
	 * 
	 * @param systemDate the Date
	 * @param page       the Pageable
	 * @return the List D
	 */
	Page<D> findAllBySystemDate(Date systemDate, Pageable page);

	/**
	 * Obtenemos datos filtrando por system date
	 * 
	 * @param systemDate the Date
	 * @param ucr        the ucr
	 * @param page       the Pagination
	 * @return the List D
	 */
	Page<D> findAllBySystemDateAndUcr(Date systemDate, String ucr, Pageable page);

	/**
	 * Obtenemos datos filtrando por system date
	 * 
	 * @param systemDate the Date
	 * @return the List D
	 */
	List<D> findAllBySystemDate(Date systemDate);

	/**
	 * Obtenemos datos filtrando por system date
	 * 
	 * @param systemDate the Date
	 * @param ucr        the ucr
	 * @return the List D
	 */
	List<D> findAllBySystemDateAndUcr(Date systemDate, String ucr);

	/**
	 * Obtenemos datos filtrando por system date y office
	 * 
	 * @param systemDate the Date
	 * @param office     the office
	 * @return the List D
	 */
	List<D> findAllBySystemDateAndOfficeStartsWith(Date systemDate, String office);

}
