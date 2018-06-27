package sjsu.jentab.EaseYourLease.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import sjsu.jentab.EaseYourLease.model.Flat;

import java.util.List;
@Component
public interface FlatDAO extends CrudRepository<Flat,Integer> {
    public List<Flat> findByApartmentId(Integer apartmentID);
    public Flat findByFlatName(String flatid);

}
