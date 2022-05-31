package es.santander.ucrapl.mcs.service;

import java.util.List;

import es.santander.ucrapl.mcs.dto.BaseDTO;
import es.santander.ucrapl.mcs.dto.PageableDTO;
import es.santander.ucrapl.msc.front.Ordenation;
import es.santander.ucrapl.msc.front.Pagination;

/**
 * Base Service
 * 
 * @author jslopez
 *
 * @param <D> the BseDTO
 */
public interface BaseService<D extends BaseDTO> extends GenericService<D> {

	/**
	 * Retorna los registros por la ultima fecha de sistema
	 * 
	 * @param ucr   the ucr
	 * @param order the Ordenation
	 * @param page  the Pagination
	 * @return List D
	 */
	PageableDTO<D> findAllByLastSystemDate(final String ucr, Pagination page, Ordenation order);

	/**
	 * Retorna los registros por la ultima fecha de sistema y por oficina
	 * 
	 * @param office the office
	 * @return List D
	 */
	List<D> findAllByLastSystemDateAndOffice(String office);

}

