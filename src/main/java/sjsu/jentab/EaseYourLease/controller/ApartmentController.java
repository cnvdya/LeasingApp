package sjsu.jentab.EaseYourLease.controller;

//import com.microsoft.aad.adal4j.AuthenticationResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sjsu.jentab.EaseYourLease.model.ApartmentVO;
import sjsu.jentab.EaseYourLease.service.ApartmentService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
//@RequestMapping("/secure/")
public class ApartmentController {

	@Autowired
	private ApartmentService apartmentService;

//	@RequestMapping(value ="/listapartments",method = RequestMethod.GET)
//	public List<Apartment> apartmentList() {
//		return apartmentService.apartmentList();
//	}

//	@RequestMapping(value = "/saveapartments", method = RequestMethod.POST)
//	public String apartmentSave(@RequestBody Apartment apartment) {
//		return apartmentService.apartmentSave(apartment);
//	}

	
	@RequestMapping(value = "/apartments", method = { RequestMethod.GET, RequestMethod.POST })
	public String apartmentPage(ModelMap model,HttpServletRequest httpRequest) {

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


		model.put("apartments",apartmentService.apartmentList());
		return "/secure/viewapartments";
	}

	@RequestMapping(value = "/addapartment", method = RequestMethod.GET)
	@ModelAttribute("ApartmentVO")
	public ModelAndView addApartmentPage(ModelMap model) {
		//model.put("apartments",apartmentService.apartmentList());
		return new ModelAndView("addapartments", "apartmentvo", new ApartmentVO());
		//return "addapartments";
	}

	@RequestMapping(value = "/saveapartment", method = RequestMethod.POST)
	public String saveApartmentPage(@Valid @ModelAttribute("apartmentvo")ApartmentVO apartmentvo,
									BindingResult result, ModelMap model) {
		apartmentService.apartmentSave(apartmentvo);
		model.put("apartments",apartmentService.apartmentList());
		return "/secure/viewapartments";
	}


	
//	@RequestMapping(value = "/addapartments", method = RequestMethod.GET)
//	public String addApartmentPage(ModelMap model) {
//		return "addapartments";
//	}

}
