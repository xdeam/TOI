package onlineclass.discuss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefultController {
    @RequestMapping("/tea/discuss")
    String teadiscux() {
        return "tea/discuss/discuss";
    }

    @RequestMapping("/stu/discuss")
    String studiscux() {
        return "stu/discuss/discuss";
    }
}
