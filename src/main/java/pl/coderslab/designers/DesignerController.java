package pl.coderslab.designers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Designer;
import pl.coderslab.model.Offer;
import pl.coderslab.offers.OfferRepository;

import java.util.List;

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

    @GetMapping("/{id}/offer")
    public String prepareUserTweetsPage(@PathVariable Long id, Model model) {
        final List<Offer> offersList = offerRepository.findAllByDesignerId(id);

        model.addAttribute("offersList", offersList);
        return "/designer/offer";
    }
}
