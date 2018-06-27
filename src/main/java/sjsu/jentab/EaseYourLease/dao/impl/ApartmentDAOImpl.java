package sjsu.jentab.EaseYourLease.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sjsu.jentab.EaseYourLease.dao.ApartmentDAO;
import sjsu.jentab.EaseYourLease.model.Apartment;

import java.util.List;

@Component
public class ApartmentDAOImpl {

    @Autowired
    private ApartmentDAO apartmentDAO;

    public List<Apartment> apartmentlist(){
        return (List<Apartment>)apartmentDAO.findAll();
    }

    public String addorUpdateApartment(Apartment apartment){
        String status;
        try{
            apartmentDAO.save(apartment);
            status="SUCCESS";
        }
        catch (Exception e){
            System.out.println(e);
            status="FAILED";
        }
        return status;
    }

    public Apartment getApartment(Integer id){
        return (Apartment)apartmentDAO.findOne(id);
    }

    public String deleteApartment(Integer id){
        String status;
        try{
            apartmentDAO.delete(id);
            status="SUCCESS";
        }
        catch (Exception e){
            System.out.println(e);
            status="FAILED";
        }
        return status;

    }
}
