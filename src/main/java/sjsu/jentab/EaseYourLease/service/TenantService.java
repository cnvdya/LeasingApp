package sjsu.jentab.EaseYourLease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjsu.jentab.EaseYourLease.dao.impl.TenantDAOImpl;
import sjsu.jentab.EaseYourLease.model.Tenant;

@Service
public class TenantService {

    @Autowired
    public TenantDAOImpl tenantDAOImpl;

    public Integer confirmTenant(Tenant tenant) {

        return tenantDAOImpl.addorUpdateTenant(tenant);
    }

    public Tenant getTenant(Integer id){
        return (Tenant)tenantDAOImpl.getTenant(id);
    }

    public Tenant getTenantByflatid(Integer id){ return(Tenant)tenantDAOImpl.getTenantByflatid(id);  }
}
