package pl.coderslab.technologists;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Technologist;

import java.util.List;

@RequestMapping("/technologist")
@Slf4j
@RequiredArgsConstructor
@Controller
public class TechnologistController {

    private final TechnologistRepository technologistRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Technologist> technologists = technologistRepository.findAll();
        model.addAttribute("technologists", technologists);
        return "/technologist/all";
    }

}
