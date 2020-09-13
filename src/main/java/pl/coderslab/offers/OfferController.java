package pl.coderslab.offers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.Buyers.BuyerRepository;
import pl.coderslab.designers.DesignerRepository;
import pl.coderslab.model.*;
import pl.coderslab.painters.PainterRepository;
import pl.coderslab.technologists.TechnologistRepository;
import pl.coderslab.wagons.WagonRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offer")
@Slf4j
@RequiredArgsConstructor
public class OfferController {

    private final OfferRepository offerRepository;
    private  final WagonRepository wagonRepository;
    private final DesignerRepository designerRepository;
    private final TechnologistRepository technologistRepository;
    private final PainterRepository painterRepository;
    private final BuyerRepository buyerRepository;


    @GetMapping("/main")
    public String mainPage() {
        return "/offer/main";
    }

    @GetMapping("/all")
    public String prepareAllOffers(Model model) {
        final List<Offer> offers = offerRepository.findAll();
        model.addAttribute("offers", offers);
        return "/offer/all";
    }

    @GetMapping("/add")
    public String prepareAddPage(Model model) {
        model.addAttribute(new Offer());
        final List<Wagon> wagons = wagonRepository.findAll();
        model.addAttribute("wagons", wagons);
        final List<Designer> designers= designerRepository.findAll();
        model.addAttribute("designers", designers);
        final List<Technologist> technologists= technologistRepository.findAll();
        model.addAttribute("technologists", technologists);
        final List<Painter> painters = painterRepository.findAll();
        model.addAttribute("painters", painters);
        final List<Buyer> buyers= buyerRepository.findAll();
        model.addAttribute("buyers", buyers);
        return "/offer/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddPage(@Valid Offer offer, BindingResult result) {

        log.debug("Entity to save: {}", offer);
        if (result.hasErrors()) {
            log.error("Entity {} fails validation.", offer);
            return "/offer/add";
        }
        log.error("Saving entity {}...", offer);
        offerRepository.save(offer);
        log.error("Entity{} has been saved.", offer);
        return "redirect:/offer/all";
    }

}
