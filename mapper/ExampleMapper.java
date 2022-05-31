package es.santander.ucrapl.mcs.map;

import org.mapstruct.Mapper;

import es.santander.ucrapl.mcs.documents.ExampleDocument;
import es.santander.ucrapl.mcs.dto.ExampleDTO;

/**
 * Mapper for the entity {@link ExampleDocument} and its DTO {@link ExampleDTO}.
 * 
 * @author jslopez
 */
@Mapper(componentModel = "spring", uses = {})
public interface CRIMapper extends BaseMapper<ExampleDTO, ExampleDocument> {

}
