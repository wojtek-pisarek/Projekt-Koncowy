package pl.coderslab.designers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Designer;

import java.util.List;

@RequestMapping("/designer")
@Slf4j
@RequiredArgsConstructor
@Controller
public class DesignerController {
private final DesignerRepository designerRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Designer> designers = designerRepository.findAll();
        model.addAttribute("designers", designers);
        return "/designer/all";
    }
}
