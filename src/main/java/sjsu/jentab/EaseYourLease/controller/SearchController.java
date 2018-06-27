package sjsu.jentab.EaseYourLease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sjsu.jentab.EaseYourLease.model.ApartmentVO;
import sjsu.jentab.EaseYourLease.model.Filter;
import sjsu.jentab.EaseYourLease.model.SearchResult;
import sjsu.jentab.EaseYourLease.service.ApartmentService;
import sjsu.jentab.EaseYourLease.service.FlatService;
import sjsu.jentab.EaseYourLease.service.SearchService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private FlatService flatService;

//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @ModelAttribute("Filter")
//    public ModelAndView searchApartment(ModelMap model) {
//        return new ModelAndView("search", "filter", new Filter());
//    }

    @RequestMapping(value = "/searchApartment", method = RequestMethod.POST)
    public String searchApartment(@Valid @ModelAttribute("filter")Filter filter,
                                    BindingResult result, ModelMap model) {
        List<SearchResult> searchResults= searchService.searchCategory(filter);
//        model.put("apartments",apartmentService.apartmentList());
        model.put("searchResults",searchResults);
        return "search";
    }


    @RequestMapping(value = "/flatDetails", method = RequestMethod.GET)
    public ModelAndView viewImages(HttpServletRequest request){

        String flatId = request.getParameter("flatId");
        ModelAndView view = new ModelAndView();
        Set<String> images = new HashSet<String>();
        SearchResult sr = searchService.searchDetails(Integer.parseInt(flatId));
        images = flatService.viewImages(flatId);
//
//
        view.addObject("searchResult",sr);
        view.addObject("images",images);
        view.setViewName("flatImages");
        return view;
    }



}
