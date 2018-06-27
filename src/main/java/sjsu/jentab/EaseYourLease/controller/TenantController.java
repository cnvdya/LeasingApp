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
import sjsu.jentab.EaseYourLease.model.Tenant;
import sjsu.jentab.EaseYourLease.service.FlatService;
import sjsu.jentab.EaseYourLease.service.TenantService;

import javax.validation.Valid;

@Controller
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private FlatService flatService;

/*    @RequestMapping(value = "/rentThisApartment", method = RequestMethod.POST)
    public String rentThisApartment(@RequestParam("flatId")Integer flatId, ModelMap model) {
        model.put("flats",tenantService.flatslist(flatId));
        return "assigntenant";
    }
 */

    @RequestMapping(value = "/rentapartment", method = RequestMethod.GET)
    @ModelAttribute("Tenant")
    public ModelAndView addApartmentPage(@RequestParam("flatid") Integer flatid,ModelMap model) {
        model.put("flatid",flatid);
        model.put("flatName",flatService.getFlatbyid(flatid).getFlatName());
        return new ModelAndView("rentapartment", "tenant", new Tenant());
        //return "addapartments";
    }

    @RequestMapping(value = "/confirmtenant", method = RequestMethod.POST)
    public String tenantDetailPage(@Valid @ModelAttribute("tenant")Tenant tenant,
                                    BindingResult result, ModelMap model) {
        Integer tid=tenantService.confirmTenant(tenant);
        System.out.println("tid:" +tid);
        Tenant tenant1 = tenantService.getTenant(tid);
        model.put("flat",flatService.getFlatbyid(tenant1.getFlatid()));
        model.put("tenantDetail",tenant1);
        return "tenantDetail";
    }

    @RequestMapping(value = "/viewTenant", method = RequestMethod.GET)
    public String tenantDetail(@RequestParam("flatid") Integer flatid,ModelMap model)
    {
        Tenant tenant1 = tenantService.getTenantByflatid(flatid);
        model.put("flat",flatService.getFlatbyid(tenant1.getFlatid()));
        model.put("tenantDetail",tenant1);
//        model.put("tenantDetail",tenantService.getTenantByflatid(flatid));
        return "tenantDetail";

    }

}
