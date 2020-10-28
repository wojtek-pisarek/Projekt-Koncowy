package pl.coderslab.painters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Buyer;
import pl.coderslab.model.Offer;
import pl.coderslab.model.Painter;
import pl.coderslab.offers.OfferRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/painter")
@Slf4j
@RequiredArgsConstructor
@Controller
public class PainterController {

    private final PainterRepository painterRepository;
    private final OfferRepository offerRepository;


    @GetMapping("/all")
    public String prepareAllPainters(Model model) {
        final List<Painter> painters = painterRepository.findAll();
        model.addAttribute("painters", painters);
        return "/painter/all";
    }

    @GetMapping("/{id}/offer")
    public String prepareOffersByPainter(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByPainterId(id);
        model.addAttribute("offersList", offersList);
        return "/painter/offer";
    }

    @GetMapping("/add")
    public String prepareAddPainter(Model model) {
        model.addAttribute(new Painter());
        return "/painter/add";
    }

    @PostMapping("/add")
    @Transactional
    public String processAddPainter(@Valid Painter painter, BindingResult result) {
        log.debug("Entity to save: {}", painter);
        if (result.hasErrors()) {
            log.error("Entity {} fails validation.", painter);
            return "/painter/add";
        }
        log.error("Saving entity {}...", painter);
        painterRepository.save(painter);
        log.error("Entity{} has been saved.", painter);
        return "redirect:/painter/all";
    }

    @GetMapping("/delete")
    public String prepareDeletePainter(@RequestParam Long id, Model model) {
        log.debug("Preparing to delete designer with id {}...", id);
        final Optional<Painter> toDelete = painterRepository.findById(id);
        if (toDelete.isEmpty()) {
            log.warn("User with id {} does not exist in DB!", id);
            return "redirect:/painter/all";
        }
        log.debug("Preparing user {} to delete....", toDelete.get());
        model.addAttribute(toDelete.get());
        return "/painter/delete";
    }

    @PostMapping("/delete")
    @Transactional
    public String processDeletePainter(Painter painter) {
        final Optional<Painter> toDelete = painterRepository.findById(painter.getId());
        if (toDelete.isEmpty()) {
            log.warn("Entity {} does not exist in Db!", painter);
        } else {
            log.debug("Deleting entity {}...", toDelete.get());
            painterRepository.delete(toDelete.get());
            log.debug("Entity {} has been deleted. ", toDelete.get());
        }
        return "redirect:/painter/all";
    }

    @GetMapping("/update")
    public String prepareUpdatePainter(@RequestParam Long id, Model model) {
        log.debug("Preparing to update user with id{}...", id);
        final Optional<Painter> toUpdate = painterRepository.findById(id);
        if (toUpdate.isEmpty()) {
            log.warn("User with id {} does not exist", id);
            return "redirect:/painter/all";
        }
        log.debug("Entity {} before updating .", toUpdate.get());
        model.addAttribute(toUpdate.get());
        return "/painter/update";
    }

    @PostMapping("/update")
    @Transactional
    public String processUpdatePainter(@Valid Painter painter, BindingResult result) {
        log.debug("Entity from request {} to update.", painter);
        if (result.hasErrors()) {
            log.warn("Entity {} fails validation!", painter);
            return "painter/update";
        }
        final Optional<Painter> toUpdate = painterRepository.findById(painter.getId());
        if (toUpdate.isEmpty()) {
            log.warn("Entity {} does not exist in DB!", painter);
        } else {
            final Painter updating = toUpdate.get();
            log.debug("Updating entity {}...", updating);
            updating.setName(painter.getName());
            updating.setSurname(painter.getSurname());
            updating.setEmail(painter.getEmail());
            updating.setPhoneNumber(painter.getPhoneNumber());
            final Painter updated = painterRepository.save(updating);
            log.debug("Entity  {}  has been updated.", updated);
        }
        return "redirect:/painter/all";
    }
}

