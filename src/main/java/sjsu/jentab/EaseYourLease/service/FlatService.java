package sjsu.jentab.EaseYourLease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjsu.jentab.EaseYourLease.dao.impl.FlatDAOImpl;
import sjsu.jentab.EaseYourLease.model.Flat;
import sjsu.jentab.EaseYourLease.model.FlatVO;

import java.util.List;
import java.util.Set;

@Service
public class FlatService {

    @Autowired
    private FlatDAOImpl flatDAO;

    public List<Flat> flatslist(Integer apartmentId) {
        return flatDAO.flatslist(apartmentId);
    }

    public String flatSave(FlatVO flat) {
    	
    	Flat flat1 = new Flat();
    	flat1.setApartment(flat.getApartment());
    	flat1.setFlatName(flat.getFlatName());
    	flat1.setDetails(flat.getDetails());
    	
    	flat1.setPrice(flat.getPrice());
    	flat1.setType(flat.getType());
    	flat1.setId(flat.getId());
        flat.setAvailability("true");
        //uploadToS3Service(flat.getImages());
        
        return flatDAO.addorUpdateFlat(flat1,flat.getImages());
    }
    
  

    public Flat getFlatbyid(Integer id){
        return flatDAO.getFlatbyid(id);
    }
    
	public Set<String> searchLabelsService(String labelName) {
		return flatDAO.searchLabelsDAO(labelName);
	}

	public Set<String> viewImages(String flatId) {
		return flatDAO.viewImages(flatId);
	}
	
}
