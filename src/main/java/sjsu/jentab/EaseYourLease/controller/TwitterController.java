package sjsu.jentab.EaseYourLease.controller;

import org.springframework.stereotype.Controller;

@Controller
public class TwitterController {

//    private Twitter twitter;
//    private ConnectionRepository connectionRepository;
//
//    @Inject
//    public TwitterController(Twitter twitter, ConnectionRepository connectionRepository) {
//        this.twitter = twitter;
//        this.connectionRepository = connectionRepository;
//    }
//
//
//    @RequestMapping(method= RequestMethod.GET ,value="/twitterconnect")
//    public String helloTwitter(ModelMap model) {
//        if (connectionRepository.findPrimaryConnection(Twitter.class) == null) {
//            return "redirect:/connect/twitter";
//        }
//        twitter.timelineOperations().updateStatus("We have Apartments available for rent at affordable prices.\n" +
//                "Please contact +1*******332 for more information");
//        model.addAttribute(twitter.userOperations().getUserProfile());
//        CursoredList<TwitterProfile> friends = twitter.friendOperations().getFriends();
//        model.addAttribute("friends", friends);
//        return "twitterconnect";
//    }
}
