package proto.business.service.impl;

import org.springframework.stereotype.Service;

import proto.business.model.Place;
import proto.business.service.ITestService;

/**
 * Buisness service test implementation
 * 
 * @author ecaillat
 *
 */
@Service(value = "testService")
public class TestServiceImpl implements ITestService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see proto.service.ITestService#foo(java.lang.String)
	 */
	@Override
	public Place foo(String arg) {
		return new Place();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see proto.service.ITestService#createPlace(proto.model.Place)
	 */
	@Override
	public String createPlace(Place place) {
		if (place == null) {
			return "";
		}
		return place.getName();
	}

}
