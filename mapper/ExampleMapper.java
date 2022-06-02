package mapper;

import org.mapstruct.Mapper;

import documents.ExampleDocument;
import dto.ExampleDTO;

/**
 * Mapper for the entity {@link ExampleDocument} and its DTO {@link ExampleDTO}.
 * 
 * @author jslopez
 */
@Mapper(componentModel = "spring", uses = {})
public interface CRIMapper extends BaseMapper<ExampleDTO, ExampleDocument> {

}
