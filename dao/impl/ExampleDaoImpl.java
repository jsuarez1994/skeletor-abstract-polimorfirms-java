package dao.impl;

import org.springframework.stereotype.Component;

import dao.exampleDao;
import documents.exampleDocument;
import dto.exampleDTO;
import map.exampleMapper;
import repository.exampleRepository;

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
