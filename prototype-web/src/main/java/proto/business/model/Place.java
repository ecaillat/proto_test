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
	 * The Google Place ID
	 */
	private String googlePlaceId;
	/**
	 * The description
	 */
	private String description;
	/**
	 * The address
	 */
	private String address;

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

	/**
	 * @return the googlePlaceId
	 */
	public String getGooglePlaceId() {
		return googlePlaceId;
	}

	/**
	 * @param googlePlaceId
	 *            the googlePlaceId to set
	 */
	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
