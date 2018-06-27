package sjsu.jentab.EaseYourLease.controller;


import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sjsu.jentab.EaseYourLease.config.PaypalPaymentIntent;
import sjsu.jentab.EaseYourLease.config.PaypalPaymentMethod;
import sjsu.jentab.EaseYourLease.service.PaypalService;
import sjsu.jentab.EaseYourLease.util.URLUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PaypalController {

    @Autowired
    private PaypalService paypalService;



    @RequestMapping(method = RequestMethod.POST, value = "/pay")
    public String pay( HttpServletRequest request){
        System.out.println("*********PAYMENT CREATION STARTED*********** ");

        String cancelUrl = URLUtils.getBaseURl(request) + "/" +"apartments";
        String successUrl = URLUtils.getBaseURl(request) + "/" + "payRent";
        System.out.println("payment cancelUrl "+cancelUrl);
        System.out.println("payment successUrl "+successUrl);

        try {
            Payment payment = paypalService.createPayment(
                    4.00,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }



    @RequestMapping(method = {RequestMethod.GET}, value = "/payRent")
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        try {
            System.out.println("payment paymentId "+paymentId);
            System.out.println("payment payerId "+payerId);
            Payment payment = paypalService.executePayment(paymentId, payerId);

            if(payment.getState().equals("approved")){
                System.out.println("payment done");
                return "paymentSuccess";
            }
        } catch (PayPalRESTException e) {
            e.printStackTrace();
            System.out.println("failed with "+e.getMessage());
        }

        return "redirect:/apartments";
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/paymentSuccessTest")
    public String paymentSuccessTest(ModelMap model){
        return "paymentSuccess";
    }


}
