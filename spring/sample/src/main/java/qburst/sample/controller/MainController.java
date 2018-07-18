package qburst.sample.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {

    @Value("${message.hello}")
    public String data;

    @RequestMapping("/")
    public String greeting(Model model) {
        model.addAttribute("msg",data);
        return "pgm";
    }

}
