package proto.business.service;

import proto.business.model.Place;

/**
 * API de service de test
 * 
 * @author ecaillat
 *
 */
public interface ITestService {

	/**
	 * foo test operation
	 * 
	 * @param arg
	 *            an argument
	 * @return a place
	 */
	Place foo(String arg);

	/**
	 * create a place and return the ID
	 * 
	 * @param place
	 *            the place to create
	 * @return the name
	 */
	String createPlace(Place place);
}
