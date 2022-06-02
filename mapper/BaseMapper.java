package map;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D>      - DTO type parameter.
 * @param <E> - Document type parameter.
 */

public interface BaseMapper<D, E> {


	/**
	 * Map DTO to DOCUMENT
	 * @param item the DTO
	 * @return DOCUMENT
	 */
	E toDocument(D item);

	/**
	 * Map DOCUMENT to DTO
	 * @param item the DOCUMENT
	 * @return DTO
	 */
	D toDto(E item);

	/**
	 * Map List DTO to List DOCUMENT
	 * @param list the List DTO
	 * @return List DOCUMENT
	 */
	List<E> toDocument(List<D> list);

	/**
	 * Map List DOCUMENT to List DTO
	 * @param list the List DOCUMENT
	 * @return List DTO
	 */
	List<D> toDto(List<E> list);
}
