package pl.coderslab.painters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Offer;
import pl.coderslab.model.Painter;
import pl.coderslab.offers.OfferRepository;

import java.util.List;

@RequestMapping("/painter")
@Slf4j
@RequiredArgsConstructor
@Controller
public class PainterController {

    private final PainterRepository painterRepository;
    private final OfferRepository offerRepository;


    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Painter> painters = painterRepository.findAll();
        model.addAttribute("painters", painters);
        return "/painter/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareUserTweetsPage(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByPainterId(id);
        model.addAttribute("offersList", offersList);
        return "/painter/offer";
    }
}

