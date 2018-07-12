package my.com.freewebdesign.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    public static final String PARAM_ID = "id";

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return "This is index page<br/><a href='/welcome?id=123'>Welcome</a>";
    }

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String welcome(@RequestParam Long id,
                          HttpServletRequest request) {

        request.setAttribute(PARAM_ID, id);
        return "This is welcome page, ID is "+ id+
                ", attribute is "+
                request.getAttribute(PARAM_ID);
    }
}
