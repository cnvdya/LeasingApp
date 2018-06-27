package sjsu.jentab.EaseYourLease.controller;


import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PageOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public FacebookController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/facebookconnect")
    public String helloFacebook(ModelMap model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            System.out.println("****************......findPrimaryConnection is null ");
            return "redirect:/connect/facebook";
        }
        String message="We have Apartments available for rent at affordable prices.\n" +
                "Please contact +1*******332 for more information";
        //Page id 1478571025525540
        PageOperations pageOps = facebook.pageOperations();

        System.out.println("****************......message "+message+ " pageOps "+pageOps);

        System.out.println("****************......message "+message+ " accounts size -"+pageOps.getAccounts().size());


        for(org.springframework.social.facebook.api.Account account : pageOps.getAccounts()) {
            System.out.println("****************.....account"+account);

            String pageid=account.getId();
            System.out.println("****************.....page id "+pageid);

            facebook.pageOperations().post(pageid, message);
            System.out.println("****************......message sent......yayyyyy.......");
            System.out.println("****************----pageid-----"+account.getId());
    }

//        String [] fields = { "id", "email",  "first_name", "last_name" };
//        User userProfile = facebook.fetchObject("me", User.class, fields);
//        System.out.println(fields);
//        System.out.println("****************UserProfile" + userProfile);
//        System.out.println("****************UserProfile first name" + userProfile.getFirstName());
//        System.out.println("****************UserProfile Id" + userProfile.getId());
//
//
//        System.out.println("****************my b'dy"+ userProfile.getBirthday());
//
//        model.addAttribute("facebookProfile", userProfile);
//        PagedList<Post> feed = facebook.feedOperations().getFeed();
//
//
////        Page page = pageOps.getPage("1478571025525540");
//
////        facebook.pageOperations().post(page.getId(), message);
//
//
//
//        System.out.println(feed);
//        System.out.println("****************feed message " + feed.get(0).getMessage());
//        System.out.println("****************feed id " + feed.get(0).getId());
//        System.out.println("****************feed name" + feed.get(0).getName());


//        model.addAttribute("feed", feed);
        return "fbpostSuccess";
    }

}


