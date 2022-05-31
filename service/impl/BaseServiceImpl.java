package es.santander.ucrapl.mcs.service.impl;

import java.util.List;

import es.santander.ucrapl.mcs.documents.BaseDocument;
import es.santander.ucrapl.mcs.dto.BaseDTO;
import es.santander.ucrapl.mcs.dto.PageableDTO;
import es.santander.ucrapl.mcs.map.BaseMapper;
import es.santander.ucrapl.mcs.repository.BaseRepository;
import es.santander.ucrapl.msc.front.Ordenation;
import es.santander.ucrapl.msc.front.Pagination;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase Abstracta generica
 * 
 * @author jslopez
 *
 * @param <D> the DTO
 * @param <E> the DOCUMENT
 * @param <R> the REPOSITORY
 * @param <M> the MAPPER
 */
@Slf4j
@Getter
public class BaseServiceImpl<D extends BaseDTO, E extends BaseDocument, R extends BaseRepository<E>, M extends BaseMapper<D, E>>
		extends GenericServiceImpl<D, E, R, M> {

	/**
	 * Retorna los registros por la ultima fecha de sistema
	 * 
	 * @param ucr   the ucr
	 * @param order the Ordenation
	 * @param page  the Pagination
	 * @return List D
	 */
	public PageableDTO<D> findAllByLastSystemDate(String ucr, Pagination page, Ordenation order) {
		log.info("Inicio CRIServiceImpl.findAllByLastSystemDate");
		PageableDTO<D> response = dao.findAllByLastSystemDate(ucr, page, order);
		log.info("Fin CRIServiceImpl.findAllByLastSystemDate");
		return response;
	}

	/**
	 * Retorna los registros por la ultima fecha de sistema y por oficina
	 * 
	 * @param office the office
	 * @return List D
	 */
	public List<D> findAllByLastSystemDateAndOffice(String office) {
		log.info("Inicio BaseDaoImpl.findAllByLastSystemDateAndOffice");
		List<D> response = dao.findAllByLastSystemDateAndOffice(office);
		log.info("Fin BaseDaoImpl.findAllByLastSystemDateAndOffice");
		return response;
	}

}
