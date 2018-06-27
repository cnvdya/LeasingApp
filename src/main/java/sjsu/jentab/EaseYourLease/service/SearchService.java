package sjsu.jentab.EaseYourLease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sjsu.jentab.EaseYourLease.dao.impl.SearchDAOImpl;
import sjsu.jentab.EaseYourLease.model.Apartment;
import sjsu.jentab.EaseYourLease.model.ApartmentVO;
import sjsu.jentab.EaseYourLease.model.Filter;
import sjsu.jentab.EaseYourLease.model.SearchResult;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    SearchDAOImpl searchDAO;



    public List<SearchResult> searchCategory(Filter filter) {
        System.out.println(filter.getName());
        System.out.println(filter.getType());
        System.out.println(filter.getPrice());
        System.out.println(filter.getAmenity());

        List<SearchResult> searchResults= searchDAO.getFiles(filter);
        return searchResults;

    }

    public SearchResult searchDetails(int flatid){
        return searchDAO.getdetails(flatid);
    }
}
