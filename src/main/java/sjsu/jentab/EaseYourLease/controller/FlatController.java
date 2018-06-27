package sjsu.jentab.EaseYourLease.controller;

//import com.microsoft.aad.adal4j.AuthenticationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sjsu.jentab.EaseYourLease.model.FlatVO;
import sjsu.jentab.EaseYourLease.service.ApartmentService;
import sjsu.jentab.EaseYourLease.service.FlatService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class FlatController {


	@Autowired
	private FlatService flatService;

	@Autowired
	private ApartmentService apartmentService;

//	@RequestMapping(value = "/saveflat", method = RequestMethod.POST)
//	public String flatSave(@RequestBody Flat flat) {
//		return flatService.flatSave(flat);
//	}

//	@RequestMapping(value = "/viewflat", method = RequestMethod.POST)
//	public List<Flat> flatslist(@RequestParam Integer apartmentId) {
//		return flatService.flatslist(apartmentId);
//	}

	@RequestMapping(value = "/viewflats", method = RequestMethod.GET)
	public String viewflattypePage(@RequestParam("apartmentId")Integer apartmentId,ModelMap model,HttpServletRequest httpRequest) {
		System.out.println("Apartment ID received : "+apartmentId);
		//apartmentService.getApartment(apartmentId);
//		HttpSession session = httpRequest.getSession();
//		AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
//		if (result == null) {
//			model.addAttribute("error", new Exception("AuthenticationResult not found in session."));
//			return "/error";
//		} else {
//			try {
//				model.put("userInfo", result.getUserInfo());
//			} catch (Exception e) {
//				model.addAttribute("error", e);
//				return "/error";
//			}
//		}

		model.put("apartmentName",apartmentService.getApartment(apartmentId).getApartmentName());
		model.put("apartmentid",apartmentId);
		model.put("flats",flatService.flatslist(apartmentId));
		return "viewflats";
	}

	@RequestMapping(value = "/addflat", method = RequestMethod.GET)
	@ModelAttribute("FlatVO")
	public ModelAndView addflatPage(@RequestParam("apartmentid") Integer apartmentid,ModelMap model) {
		model.put("apartmentid",apartmentid);
		return new ModelAndView("addflat", "flatVO", new FlatVO());
	}

	@RequestMapping(value = "/saveFlat", method = RequestMethod.POST)
	public ModelAndView saveFlatPage(@Valid @ModelAttribute("flatVO")FlatVO flatVO,@RequestParam MultipartFile images,
								   BindingResult result, ModelMap model,HttpServletRequest servletRequest,HttpSession session) {


		flatService.flatSave(flatVO);
		
		Integer aid=flatVO.getApartment().getId();
		System.out.println("apartmentid:" +flatVO.getApartment().getId());
		model.put("flats",flatService.flatslist(aid));
		//return "viewflats";
		return new ModelAndView("redirect:" + "viewflats?apartmentId="+aid);
	}

	@RequestMapping(value = "/viewImages", method = RequestMethod.GET)
	public ModelAndView viewImages(HttpServletRequest request){
		
		String flatId = request.getParameter("fileId");
		ModelAndView view = new ModelAndView();
		Set<String> images = new HashSet<String>();
		images = flatService.viewImages(flatId);
		
        	
        view.addObject("images",images);
        view.addObject("flatId",flatId);
        view.setViewName("flatImages");
        return view;
	}
	
	@RequestMapping(value = "/searchLabels", method = RequestMethod.GET)
	public ModelAndView searchLabels(@RequestParam("searchLabel") String labelName,HttpServletRequest request) {

		ModelAndView view = new ModelAndView();
		Set<String> imagesList = flatService.searchLabelsService(labelName);
		view.addObject("imagesList", imagesList);
		view.setViewName("searchAmentites");
		return view;
	}
				 
		
	
}
