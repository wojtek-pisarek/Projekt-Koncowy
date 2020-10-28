package pl.coderslab.technologists;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Buyer;
import pl.coderslab.model.Offer;
import pl.coderslab.model.Technologist;
import pl.coderslab.offers.OfferRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/technologist")
@Slf4j
@RequiredArgsConstructor
@Controller
public class TechnologistController {

    private final TechnologistRepository technologistRepository;
    private final OfferRepository offerRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Technologist> technologists = technologistRepository.findAll();
        model.addAttribute("technologists", technologists);
        return "/technologist/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareUserTweetsPage(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByTechnologistId(id);
        model.addAttribute("offersList", offersList);
        return "/technologist/offer";
    }

    @GetMapping("/add")
    public String prepareAddTechnologist(Model model) {
        model.addAttribute(new Technologist());
        return "/technologist/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddTechnologist(@Valid Technologist technologist, BindingResult result) {
        log.debug("Entity to save: {}", technologist);
        if (result.hasErrors()) {
            log.error("Entity {} fails validation.", technologist);
            return "/technologist/add";
        }
        log.error("Saving entity {}...", technologist);
        technologistRepository.save(technologist);
        log.error("Entity{} has been saved.", technologist);
        return "redirect:/buyer/all";
    }

    @GetMapping("/update")
    public String prepareUpdateTechnologist(@RequestParam Long id, Model model) {
        log.debug("Preparing to update user with id{}...", id);
        final Optional<Technologist> toUpdate = technologistRepository.findById(id);
        if (toUpdate.isEmpty()) {
            log.warn("User with id {} does not exist", id);
            return "redirect:/technologist/all";
        }
        log.debug("Entity {} before updating .", toUpdate.get());
        model.addAttribute(toUpdate.get());
        return "/technologist/update";
    }

    @PostMapping("/update")
    @Transactional
    public String processUpdateTechnologist(@Valid Technologist technologist, BindingResult result) {
        log.debug("Entity from request {} to update.", technologist);
        if (result.hasErrors()) {
            log.warn("Entity {} fails validation!", technologist);
            return "technologist/update";
        }
        final Optional<Technologist> toUpdate = technologistRepository.findById(technologist.getId());
        if (toUpdate.isEmpty()) {
            log.warn("Entity {} does not exist in DB!", technologist);
        } else {
            final Technologist updating = toUpdate.get();
            log.debug("Updating entity {}...", updating);
            updating.setName(technologist.getName());
            updating.setSurname(technologist.getSurname());
            updating.setEmail(technologist.getEmail());
            updating.setPhoneNumber(technologist.getPhoneNumber());
            final Technologist updated = technologistRepository.save(updating);
            log.debug("Entity  {}  has been updated.", updated);
        }
        return "redirect:/technologist/all";
    }

    @GetMapping("/delete")
    public String prepareDeleteTechnologist(@RequestParam Long id, Model model) {
        log.debug("Preparing to delete designer with id {}...", id);
        final Optional<Technologist> toDelete = technologistRepository.findById(id);
        if (toDelete.isEmpty()) {
            log.warn("User with id {} does not exist in DB!", id);
            return "redirect:/buyer/all";
        }
        log.debug("Preparing user {} to delete....", toDelete.get());
        model.addAttribute(toDelete.get());
        return "/technologist/delete";
    }

    @PostMapping("/delete")
    @Transactional
    public String processDeleteTechnologist(Technologist technologist) {
        final Optional<Technologist> toDelete = technologistRepository.findById(technologist.getId());
        if (toDelete.isEmpty()) {
            log.warn("Entity {} does not exist in Db!", technologist);
        } else {
            log.debug("Deleting entity {}...", toDelete.get());
            technologistRepository.delete(toDelete.get());
            log.debug("Entity {} has been deleted. ", toDelete.get());
        }
        return "redirect:/technologist/all";
    }
}
