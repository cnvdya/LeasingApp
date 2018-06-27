package sjsu.jentab.EaseYourLease.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {

//    @RequestMapping("/")
//    public String index() {
//        return "/test";
//    }

        @RequestMapping(value = "/")
    public String aboutPage(ModelMap model) {
        return "/secure/aboutUs";
    }
}
