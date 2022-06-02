package dao;

import java.util.Date;
import java.util.List;

import dto.BaseDTO;
import dto.PageableDTO;
import Ordenation;
import Pagination;

/**
 * Dao de ManagerDocument
 * 
 * @author jslopez
 *
 * @param <D> the Base DTO
 */
public interface BaseDao<D extends BaseDTO> extends GenericDao<D> {

	/**
	 * Retorna los registros por la ultima fecha de sistema
	 * 
	 * @param ucr   the ucr
	 * @param order the Ordenation
	 * @param page  the Pagination
	 * @return PageableDTO
	 */
	PageableDTO<D> findAllByLastSystemDate(final String ucr, Pagination page, Ordenation order);

	/**
	 * Retorna los registros por la ultima fecha de sistema y por oficina
	 * 
	 * @param office the office
	 * @return List D
	 */
	List<D> findAllByLastSystemDateAndOffice(String office);

	/**
	 * 
	 * Obtenemos ultima fecha del sistema
	 * 
	 * @return Date
	 */
	Date getLastSystemDate();

}
