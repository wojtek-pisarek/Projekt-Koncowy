package pl.coderslab.wagons;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.*;
import pl.coderslab.offers.OfferRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/wagon")
@Slf4j
@RequiredArgsConstructor
@Controller
public class WagonController {
     private final WagonRepository wagonRepository;
     private final OfferRepository offerRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Wagon> wagons = wagonRepository.findAll();
        model.addAttribute("wagons", wagons);
        return "/wagon/all";
    }

    @GetMapping("/add")
    public String prepareAddPage(Model model) {
        model.addAttribute(new Wagon());
        return "/wagon/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddPage(@Valid Wagon wagon, BindingResult result) {
        log.debug("Entity to save: {}", wagon);
        if (result.hasErrors()) {
            log.error("Entity {} fails validation.", wagon);
            return "/wagon/add";
        }
        log.error("Saving entity {}...", wagon);
        wagonRepository.save(wagon);
        log.error("Entity{} has been saved.", wagon);
        return "redirect:/wagon/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareUserTweetsPage(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByWagonId(id);
        model.addAttribute("offersList", offersList);
        return "/wagon/offer";
    }


}
