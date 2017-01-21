package proto.jms;

import javax.annotation.Resource;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import proto.business.model.Place;
import proto.mongo.repo.PlaceRepository;

@Component
public class PlaceReceiver {

	@Resource
	private PlaceRepository placeRepository;

	@JmsListener(destination = "post_place", containerFactory = "myFactory")
	public void postPlace(Place place) {
		placeRepository.save(place);
	}
}
