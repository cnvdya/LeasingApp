package sjsu.jentab.EaseYourLease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjsu.jentab.EaseYourLease.dao.impl.ApartmentDAOImpl;
import sjsu.jentab.EaseYourLease.model.Apartment;
import sjsu.jentab.EaseYourLease.model.ApartmentVO;

import java.util.List;

@Service
public class ApartmentService {

    @Autowired
    private ApartmentDAOImpl apartmentDAOImpl;


    public List<Apartment> apartmentList() {
        return apartmentDAOImpl.apartmentlist();
    }

    public String apartmentSave(ApartmentVO apartment) {

        Apartment apartment1 = new Apartment();
        apartment1.setAdressLine1(apartment.getAdressLine1());
        apartment1.setAdressLine2(apartment.getAdressLine2());

        apartment1.setApartmentName(apartment.getApartmentName());
        apartment1.setCity(apartment.getCity());

        apartment1.setCode(apartment.getCode());
        apartment1.setCountry(apartment.getCountry());

        apartment1.setId(apartment.getId());
        apartment1.setState(apartment.getState());

        return apartmentDAOImpl.addorUpdateApartment(apartment1);
    }

    public Apartment getApartment(Integer id){
        return (Apartment)apartmentDAOImpl.getApartment(id);
    }
}
