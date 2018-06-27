package sjsu.jentab.EaseYourLease.dao;

import org.springframework.data.repository.CrudRepository;
import sjsu.jentab.EaseYourLease.model.Tenant;

public interface TenantsDAO extends CrudRepository<Tenant,Integer> {

    public Tenant findByFlatid(Integer Flatid);

}
