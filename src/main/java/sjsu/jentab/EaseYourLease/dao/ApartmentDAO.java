package sjsu.jentab.EaseYourLease.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import sjsu.jentab.EaseYourLease.model.Apartment;
@Component
public interface ApartmentDAO extends CrudRepository <Apartment,Integer> {


}
