package pl.coderslab.Buyers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Buyer;
import pl.coderslab.model.Offer;
import pl.coderslab.offers.OfferRepository;

import java.util.List;

@RequestMapping("/buyer")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BuyerController {

    private final BuyerRepository buyerRepository;
    private final OfferRepository offerRepository;


    @GetMapping("/all")
    public String prepareAllBuyers(Model model) {
        final List<Buyer> buyers = buyerRepository.findAll();
        model.addAttribute("buyers", buyers);
        return "/buyer/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareBuyerOffers(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByBuyerId(id);
        model.addAttribute("offersList", offersList);
        return "/buyer/offer";
    }


}
