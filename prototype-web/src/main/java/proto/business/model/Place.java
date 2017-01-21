package proto.business.model;

import org.springframework.data.annotation.Id;

/**
 * The Place entity
 * 
 * @author ecaillat
 *
 */
public class Place {

	/**
	 * unique ID
	 */
	@Id
	private String id;
	/**
	 * The name of the place
	 */
	private String name;
	/**
	 * The coordinates of the place
	 */
	private String coordinates;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the coordinates
	 */
	public String getCoordinates() {
		return coordinates;
	}

	/**
	 * @param coordinates
	 *            the coordinates to set
	 */
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

}
