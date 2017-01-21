package proto.mongo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import proto.business.model.Place;

/**
 * The Mongo repository and REST resource for the places
 * 
 * @author ecaillat
 *
 */
@RepositoryRestResource(collectionResourceRel = "place", path = "place")
public interface PlaceRepository extends MongoRepository<Place, String> {

	/**
	 * Find places by name
	 * 
	 * @param name
	 *            the name of the place
	 * @return The list of found places
	 */
	List<Place> findByName(@Param("name") String name);

}
