package pl.coderslab.designers;

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

@RequestMapping("/designer")
@Slf4j
@RequiredArgsConstructor
@Controller
public class DesignerController {
    private final DesignerRepository designerRepository;
    private final OfferRepository offerRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Designer> designers = designerRepository.findAll();
        model.addAttribute("designers", designers);
        return "/designer/all";
    }

    @GetMapping("/add")
    public String prepareAddDesigner(Model model) {
        model.addAttribute(new Designer());
        return "/designer/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddDesigner(@Valid Designer designer, BindingResult result) {
        log.debug("Entity to save: {}", designer);
        if (result.hasErrors()) {
            log.error("Entity {} fails validation.", designer);
            return "/designer/add";
        }
        log.error("Saving entity {}...", designer);
        designerRepository.save(designer);
        log.error("Entity{} has been saved.", designer);
        return "redirect:/designer/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareUserTweetsPage(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByDesignerId(id);
        model.addAttribute("offersList", offersList);
        return "/designer/offer";
    }

    @GetMapping("/delete")
    public String prepareDeleteDesigner(@RequestParam Long id, Model model) {
        log.debug("Preparing to delete designer with id {}...", id);
        final Optional<Designer> toDelete = designerRepository.findById(id);
        if (toDelete.isEmpty()) {
            log.warn("User with id {} does not exist in DB!", id);
            return "redirect:/designer/all";
        }
        log.debug("Preparing user {} to delete....", toDelete.get());
        model.addAttribute(toDelete.get());
        return "/designer/delete";
    }

    @PostMapping("/delete")
    @Transactional
    public String processDeleteDesigner(Designer designer) {
        final Optional<Designer> toDelete = designerRepository.findById(designer.getId());
        if (toDelete.isEmpty()) {
            log.warn("Entity {} does not exist in Db!", designer);
        } else {
            log.debug("Deleting entity {}...", toDelete.get());
            designerRepository.delete(toDelete.get());
            log.debug("Entity {} has been deleted. ", toDelete.get());
        }
        return "redirect:/designer/all";
    }

    @GetMapping("/update")
    public String prepareUpdateDesigner(@RequestParam Long id, Model model) {
        log.debug("Preparing to update user with id{}...", id);
        final Optional<Designer> toUpdate = designerRepository.findById(id);
        if (toUpdate.isEmpty()) {
            log.warn("User with id {} does not exist", id);
            return "redirect:/designer/all";
        }
        log.debug("Entity {} before updating .", toUpdate.get());
        model.addAttribute(toUpdate.get());
        return "/designer/update";
    }

    @PostMapping("/update")
    @Transactional
    public String processUpdateDesigner(@Valid Designer designer, BindingResult result) {
        log.debug("Entity from request {} to update.", designer);
        if (result.hasErrors()) {
            log.warn("Entity {} fails validation!", designer);
            return "designer/update";
        }
        final Optional<Designer> toUpdate = designerRepository.findById(designer.getId());
        if (toUpdate.isEmpty()) {
            log.warn("Entity {} does not exist in DB!", designer);
        } else {
            final Designer updating = toUpdate.get();
            log.debug("Updating entity {}...", updating);
            updating.setName(designer.getName());
            updating.setSurname(designer.getSurname());
            updating.setEmail(designer.getEmail());
            updating.setPhoneNumber(designer.getPhoneNumber());
            final Designer updated = designerRepository.save(updating);
            log.debug("Entity  {}  has been updated.", updated);
        }
        return "redirect:/designer/all";
    }
}
