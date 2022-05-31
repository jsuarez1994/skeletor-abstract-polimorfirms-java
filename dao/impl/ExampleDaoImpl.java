package es.santander.ucrapl.mcs.dao.impl;

import org.springframework.stereotype.Component;

import es.santander.ucrapl.mcs.dao.exampleDao;
import es.santander.ucrapl.mcs.documents.exampleDocument;
import es.santander.ucrapl.mcs.dto.exampleDTO;
import es.santander.ucrapl.mcs.map.exampleMapper;
import es.santander.ucrapl.mcs.repository.exampleRepository;

/**
 * Dao de Example 
 * asociado a Base
 * 
 * @author jslopez
 */
@Component("exampleDao")
public class ExampleDaoImpl extends BaseDaoImpl<ExampleDTO, ExampleDocument, ExampleRepository, ExampleMapper> 
							implements ExampleDao {
}
