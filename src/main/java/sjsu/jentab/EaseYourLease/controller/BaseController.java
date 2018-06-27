package sjsu.jentab.EaseYourLease.controller;

//import com.microsoft.aad.adal4j.AuthenticationResult;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String startPage(ModelMap model) {
//		return "home";
//	}
//
//	@RequestMapping(value = "/images/logo.png", method = RequestMethod.GET)
//	public String logoPage(ModelMap model) {
//		return "logo";
//	}
//
//


//    @RequestMapping(value = "/easeyourlease")
//    public String aboutPage(ModelMap model) {
////        HttpSession session = httpRequest.getSession();
////        AuthenticationResult result = (AuthenticationResult) session.getAttribute(AuthHelper.PRINCIPAL_SESSION_NAME);
////        if (result == null) {
////            model.addAttribute("error", new Exception("AuthenticationResult not found in session."));
////            return "/error";
////        } else {
////            try {
////                model.put("userInfo", result.getUserInfo());
////            } catch (Exception e) {
////                model.addAttribute("error", e);
////                return "/error";
////            }
////        }
//        return "/secure/aboutUs";
//    }


//	@RequestMapping(value = "/easeyourlease", method = { RequestMethod.GET, RequestMethod.POST })
//	public String aboutPage(ModelMap model,HttpServletRequest httpRequest) {
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
//		return "/secure/aboutUs";
//	}
//
//	@RequestMapping(value = "/contactus", method = { RequestMethod.GET, RequestMethod.POST })
//	public String contactPage(ModelMap model,HttpServletRequest httpRequest) {
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
//		return "contactus";
//	}




//	@GetMapping("/")
//	public String getIndex() {
//		//return "index";
//		return "home";
//	}
}
