package pl.coderslab.painters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Painter;

import java.util.List;

@RequestMapping("/painter")
@Slf4j
@RequiredArgsConstructor
@Controller
public class PainterController {

    private final PainterRepository painterRepository;

    @GetMapping("/all")
    public String prepareAllPage(Model model) {
        final List<Painter> painters = painterRepository.findAll();
        model.addAttribute("painters", painters);
        return "/painter/all";
    }
}
