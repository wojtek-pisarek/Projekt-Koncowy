package pl.coderslab.wagons;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.offers.OfferRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public String prepareAddWagon(Model model) {
        model.addAttribute(new Wagon());
        return "/wagon/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddWagon(@Valid Wagon wagon, BindingResult result) {
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

    @GetMapping("/delete")
    public String prepareDeleteWagon(@RequestParam Long id, Model model) {
        log.debug("Preparing to delete wagon with id {}...", id);
        final Optional<Wagon> toDelete = wagonRepository.findById(id);
        if (toDelete.isEmpty()) {
            log.warn("User with id {} does not exist in DB!", id);
            return "redirect:/wagon/all";
        }
        log.debug("Preparing user {} to delete....", toDelete.get());
        model.addAttribute(toDelete.get());
        return "/wagon/delete";
    }

    @PostMapping("/delete")
    @Transactional
    public String processDeleteWagon(Wagon wagon) {
        final Optional<Wagon> toDelete = wagonRepository.findById(wagon.getId());
        if (toDelete.isEmpty()) {
            log.warn("Entity {} does not exist in Db!", wagon);
        } else {
            log.debug("Deleting entity {}...", toDelete.get());
            wagonRepository.delete(toDelete.get());
            log.debug("Entity {} has been deleted. ", toDelete.get());
        }
        return "redirect:/wagon/all";
    }

    @GetMapping("/update")
    public String prepareUpdateWagon(@RequestParam Long id, Model model) {
        log.debug("Preparing to update user with id{}...", id);
        final Optional<Wagon> toUpdate = wagonRepository.findById(id);
        if (toUpdate.isEmpty()) {
            log.warn("User with id {} does not exist", id);
            return "redirect:/wagon/all";
        }
        log.debug("Entity {} before updating .", toUpdate.get());
        model.addAttribute(toUpdate.get());
        return "/wagon/update";
    }

    @PostMapping("/update")
    @Transactional
    public String processUpdateWagon(@Valid Wagon wagon, BindingResult result) {
        log.debug("Entity from request {} to update.", wagon);
        if (result.hasErrors()) {
            log.warn("Entity {} fails validation!", wagon);
            return "wagon/update";
        }
        final Optional<Wagon> toUpdate = wagonRepository.findById(wagon.getId());
        if (toUpdate.isEmpty()) {
            log.warn("Entity {} does not exist in DB!", wagon);
        } else {
            final Wagon updating = toUpdate.get();
            log.debug("Updating entity {}...", updating);
            updating.setType(wagon.getType());
            final Wagon updated = wagonRepository.save(updating);
            log.debug("Entity  {}  has been updated.", updated);
        }
        return "redirect:/wagon/all";
    }


}
