package pl.coderslab.Buyers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Buyer;
import pl.coderslab.model.Designer;
import pl.coderslab.model.Offer;
import pl.coderslab.offers.OfferRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/add")
    public String prepareAddBuyer(Model model) {
        model.addAttribute(new Buyer());
        return "/buyer/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddBuyer(@Valid Buyer buyer, BindingResult result) {
        log.debug("Entity to save: {}", buyer);
        if (result.hasErrors()) {
            log.error("Entity {} fails validation.", buyer);
            return "/buyer/add";
        }
        log.error("Saving entity {}...", buyer);
        buyerRepository.save(buyer);
        log.error("Entity{} has been saved.", buyer);
        return "redirect:/buyer/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareBuyerOffers(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByBuyerId(id);
        model.addAttribute("offersList", offersList);
        return "/buyer/offer";
    }

    @GetMapping("/delete")
    public String prepareDeleteBuyer(@RequestParam Long id, Model model) {
        log.debug("Preparing to delete designer with id {}...", id);
        final Optional<Buyer> toDelete = buyerRepository.findById(id);
        if (toDelete.isEmpty()) {
            log.warn("User with id {} does not exist in DB!", id);
            return "redirect:/buyer/all";
        }
        log.debug("Preparing user {} to delete....", toDelete.get());
        model.addAttribute(toDelete.get());
        return "/buyer/delete";
    }

    @PostMapping("/delete")
    @Transactional
    public String processDeleteDesigner(Buyer buyer) {
        final Optional<Buyer> toDelete = buyerRepository.findById(buyer.getId());
        if (toDelete.isEmpty()) {
            log.warn("Entity {} does not exist in Db!", buyer);
        } else {
            log.debug("Deleting entity {}...", toDelete.get());
            buyerRepository.delete(toDelete.get());
            log.debug("Entity {} has been deleted. ", toDelete.get());
        }
        return "redirect:/buyer/all";
    }

    @GetMapping("/update")
    public String prepareUpdateDesigner(@RequestParam Long id, Model model) {
        log.debug("Preparing to update user with id{}...", id);
        final Optional<Buyer> toUpdate = buyerRepository.findById(id);
        if (toUpdate.isEmpty()) {
            log.warn("User with id {} does not exist", id);
            return "redirect:/designer/all";
        }
        log.debug("Entity {} before updating .", toUpdate.get());
        model.addAttribute(toUpdate.get());
        return "/buyer/update";
    }

    @PostMapping("/update")
    @Transactional
    public String processUpdateDesigner(@Valid Buyer buyer, BindingResult result) {
        log.debug("Entity from request {} to update.", buyer);
        if (result.hasErrors()) {
            log.warn("Entity {} fails validation!", buyer);
            return "buyer/update";
        }
        final Optional<Buyer> toUpdate = buyerRepository.findById(buyer.getId());
        if (toUpdate.isEmpty()) {
            log.warn("Entity {} does not exist in DB!", buyer);
        } else {
            final Buyer updating = toUpdate.get();
            log.debug("Updating entity {}...", updating);
            updating.setName(buyer.getName());
            updating.setSurname(buyer.getSurname());
            updating.setEmail(buyer.getEmail());
            updating.setPhoneNumber(buyer.getPhoneNumber());
            final Buyer updated = buyerRepository.save(updating);
            log.debug("Entity  {}  has been updated.", updated);
        }
        return "redirect:/buyer/all";
    }




}
