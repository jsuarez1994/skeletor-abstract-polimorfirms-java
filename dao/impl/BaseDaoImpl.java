package es.santander.ucrapl.mcs.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import es.santander.ucrapl.mcs.documents.BaseDocument;
import es.santander.ucrapl.mcs.dto.BaseDTO;
import es.santander.ucrapl.mcs.dto.PageableDTO;
import es.santander.ucrapl.mcs.map.BaseMapper;
import es.santander.ucrapl.mcs.repository.BaseRepository;
import es.santander.ucrapl.mcs.util.Utilidades;
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
public class BaseDaoImpl<D extends BaseDTO, E extends BaseDocument, R extends BaseRepository<E>, M extends BaseMapper<D, E>> extends GenericDaoImpl<D, E, R, M> {

	/**
	 * Retorna los registros por la ultima fecha de sistema
	 * 
	 * @param ucr   the ucr
	 * @param order the Ordenation
	 * @param page  the Pagination
	 * @return List D
	 */
	public PageableDTO<D> findAllByLastSystemDate(String ucr, Pagination page, Ordenation order) {
		log.info("Inicio BaseDaoImpl.findAllByLastSystemDate");
		// Obtenemos la ultima fecha sistema
		Date lastSystemDate = getLastSystemDate();
		// Obtenemos los datos a partir de la ultima fecha
		Page<E> pageData = getPageData(ucr, lastSystemDate, Utilidades.generatePageable(page, order));
		List<D> response = mapper.toDto(pageData.getContent());
		log.info("Fin BaseDaoImpl.findAllByLastSystemDate");
		return null == response || CollectionUtils.isEmpty(response) ? new PageableDTO<>(new ArrayList<>(), 0, 0, 0)
				: new PageableDTO<>(response, pageData.getTotalElements(), pageData.getTotalPages(),
						pageData.getNumber());
	}

	/**
	 * Retorna los registros por la ultima fecha de sistema y por oficina
	 * 
	 * @param office the office
	 * @return List D
	 */
	public List<D> findAllByLastSystemDateAndOffice(String office) {
		log.info("Inicio BaseDaoImpl.findAllByLastSystemDateAndOffice: {}", office);
		Date lastSystemDate = getLastSystemDate();
		// Obtenemos los datos a partir de la ultima fecha
		List<D> response = mapper.toDto(repository.findAllBySystemDateAndOfficeStartsWith(lastSystemDate, office));
		log.info("Fin BaseDaoImpl.findAllByLastSystemDateAndOffice: {}", office);
		return response;
	}

	public Date getLastSystemDate() {
		List<E> dataLastSystemDate = repository.findFirstByOrderBySystemDateDesc();
		return (CollectionUtils.isEmpty(dataLastSystemDate)) ? new Date() : dataLastSystemDate.get(0).getSystemDate();
	}

	// ********** PRIVATES **********

	private Page<E> getPageData(String ucr, Date lastSystemDate, Pageable pagination) {
		return null == ucr ? repository.findAllBySystemDate(lastSystemDate, pagination)
				: repository.findAllBySystemDateAndUcr(lastSystemDate, ucr, pagination);
	}

}
