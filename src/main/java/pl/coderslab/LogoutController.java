package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/logout")
@Slf4j
@RequiredArgsConstructor
@Controller
public class LogoutController {

    @GetMapping("")
    public String logout() {
        return "/user/logout";
    }
}
