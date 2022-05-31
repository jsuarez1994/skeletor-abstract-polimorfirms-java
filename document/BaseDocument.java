package es.santander.ucrapl.mcs.documents;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Base
 * 
 * @author jslopez
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class BaseDocument {

	/** the id */
	@Id
	@Field("_id")
	private String id;

	/** the office */
	private String office;

	/** the comZone */
	@Field("com_zone")
	private String comZone;

	/** the comTerritorial */
	@Field("com_territorial")
	private String comTerritorial;

	/** the ucr */
	private String ucr;

	/** the systemDate */
	@Field("system_date")
	private Date systemDate;

}
