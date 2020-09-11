package pl.coderslab.offers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Offer;

import java.util.List;

@Controller
@RequestMapping("/offer")
@Slf4j
@RequiredArgsConstructor
public class OfferController {
    private final OfferRepository offerRepository;

    @GetMapping("")
    public String mainPage() {

        return "/offer/main";
    }

    @GetMapping("/all")
    public String prepareAllOffers(Model model) {
        final List<Offer> offers = offerRepository.findAll();
        model.addAttribute("offers", offers);
        return "/offer/all";
    }

}
