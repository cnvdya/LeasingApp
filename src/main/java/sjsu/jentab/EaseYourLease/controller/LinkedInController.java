package sjsu.jentab.EaseYourLease.controller;


import org.springframework.stereotype.Controller;

@Controller
public class LinkedInController {

//    private LinkedIn linkedIn;
//    private ConnectionRepository connectionRepository;
//
//    public LinkedInController(LinkedIn linkedIn, ConnectionRepository connectionRepository) {
//        this.linkedIn = linkedIn;
//        this.connectionRepository = connectionRepository;
//    }
//
//
//    @RequestMapping(method= RequestMethod.GET ,value="/linkedinconnect")
//    public String helloFacebook(ModelMap model) {
//        if (connectionRepository.findPrimaryConnection(LinkedIn.class) == null) {
//            return "redirect:/connect/linkedin";
//        }
//
//        String message="Test message";
//        System.out.println(" *****Message*****  = "+message);
//        ProfileOperations user = linkedIn.profileOperations();
//        System.out.println(" *****profileurl*****  = "+user.getProfileId());
//        System.out.println(" *****profileurl*****  = "+user.getProfileUrl());
//        NewShare.NewShareContent shareContent = new NewShare.NewShareContent("demoTitle", "https://www.linkedin.com/in/mudrita-chaturvedi-aa844588/", "https://www.linkedin.com/in/mudrita-chaturvedi-aa844588/edit/topcard/","demo description");
//        System.out.println(" *****shareContent*****  = "+shareContent.getSubmittedUrl());
//        NewShare postContent = new NewShare(message, shareContent, new NewShare.NewShareVisibility());
//        System.out.println(" *****postContent*****  = "+postContent.getContent());
//        NetworkUpdateOperations networkUpdateOperations = linkedIn.networkUpdateOperations();
//
//        System.out.println(" *****networkUpdateOperations*****  = "+networkUpdateOperations.toString());
//
//        URI uri = networkUpdateOperations.share(postContent);
//
//        System.out.println(" *****networkUpdateOperations*****  = "+uri);
//
//        System.out.println(user);
//
//        model.addAttribute("linkedInProfile",linkedIn.profileOperations().getUserProfileFull());
//
//
//
//        return "linkedin";
//    }
}
