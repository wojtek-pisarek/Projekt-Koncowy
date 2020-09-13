package pl.coderslab.Buyers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Buyer;
import pl.coderslab.model.Designer;

import java.util.List;

@RequestMapping("/buyer")
@Slf4j
@RequiredArgsConstructor
@Controller
public class BuyerController {

    private final BuyerRepository buyerRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Buyer> buyers = buyerRepository.findAll();
        model.addAttribute("buyers", buyers);
        return "/buyer/all";
    }


}
