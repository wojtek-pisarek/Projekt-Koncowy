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
import java.util.Optional;

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
        log.debug("Saving entity {}...", offer);
        offerRepository.save(offer);
        log.debug("Entity{} has been saved.", offer);
        return "redirect:/offer/all";
    }


    @GetMapping("/update")
    public String prepareUpdatePage(@RequestParam Long id, Model model) {
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
        log.error("Preparing to update user with id{}...", id);
        final Optional<Offer> toUpdate = offerRepository.findById(id);
        if (toUpdate.isEmpty()) {
            log.warn("User with id {} does not exist", id);
            return "redirect:/offer/all";
        }
        log.debug("Entity {} before updating .", toUpdate.get());
        model.addAttribute(toUpdate.get());
        return "/offer/update";
    }

    @PostMapping("/update")
    @Transactional
    public String processUpdatePage(@Valid Offer offer, BindingResult result) {
        log.debug("Entity from request {} to update.", offer);
        if (result.hasErrors()) {
            log.warn("Entity {} fails validation!", offer);
            return "offer/update";
        }
        final Optional<Offer> toUpdate = offerRepository.findById(offer.getId());
        if (toUpdate.isEmpty()) {
            log.warn("Entity {} does not exist in DB!", offer);
        } else {
            final Offer updating = toUpdate.get();
            log.debug("Updating entity {}...", updating);
            updating.setRfq(offer.getRfq());
            updating.setDate(offer.getDate());
            updating.setBuyer(offer.getBuyer());
            updating.setDesigner(offer.getDesigner());
            updating.setTechnologist(offer.getTechnologist());
            updating.setPainter(offer.getPainter());
            final Offer updated = offerRepository.save(updating);
            log.debug("Entity  {}  has been updated.", updated);
        }
        return "redirect:/offer/all";
    }

    @GetMapping("/delete")
    public String prepareDeleteOffer(@RequestParam Long id, Model model) {
        log.debug("Preparing to delete user with id {}...", id);
        final Optional<Offer> toDelete = offerRepository.findById(id);
        if (toDelete.isEmpty()) {
            log.warn("User with id {} does not exist in DB!", id);
            return "redirect:/offer/all";
        }
        log.debug("Preparing user {} to delete....", toDelete.get());
        model.addAttribute(toDelete.get());
        return "/offer/delete";
    }

    @PostMapping("/delete")
    @Transactional
    public String processDeleteOffer(Offer offer) {
        final Optional<Offer> toDelete = offerRepository.findById(offer.getId());
        if (toDelete.isEmpty()) {
            log.warn("Entity {} does not exist in Db!", offer);
        } else {
            log.debug("Deleting entity {}...", toDelete.get());
            offerRepository.delete(toDelete.get());
            log.debug("Entity {} has been deleted. ", toDelete.get());
        }
        return "redirect:/offer/all";
    }

}
