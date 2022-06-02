package dto;

import java.util.Date;

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
public class BaseDTO {

	/** the id */
	private String id;

	/** the office */
	private String office;

	/** the comZone */
	private String comZone;

	/** the comTerritorial */
	private String comTerritorial;

	/** the ucr */
	private String ucr;
	
	/** the systemDate */
	private Date systemDate;

}
