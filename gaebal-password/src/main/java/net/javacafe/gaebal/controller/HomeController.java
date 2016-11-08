package net.javacafe.gaebal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 임형태
 * @since 2015.10.29
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    @ResponseBody
    public String home() {
        return "계발자 홈페이지에 오신 걸 환영합니다.";
    }
}
