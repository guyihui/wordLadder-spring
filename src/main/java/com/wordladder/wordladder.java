package com.wordladder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class wordladder {

    @RequestMapping(value={"/","/index"})
    public String say() {
        return "<h1>Your url should be .../wordLadder?source=[word1]&target=[word2]</h1>" +
                "<h2>such as .../wordLadder?source=source&target=target</h2>"+
                "<input id=\"input1\" placeholder=\"source\"></input>" +
                "<input id=\"input2\" placeholder=\"target\"></input>"+
                "<script>" +
                "var value1=document.getElementById('input1').value" +
                "var value2=document.getElementById('input2').value" +
                "</script>"+
                "<button>lookup</button>";
    }

    @RequestMapping("/wordLadder")
    public String say(@RequestParam(value = "source",defaultValue = "source") String source,
                      @RequestParam(value = "target",defaultValue = "target") String target)throws FileNotFoundException {
        new ladder();
        return ladder.ladder(source, target);
    }

    @RequestMapping(value = "/login")
    public String login() {
        return " <body>\n" +
                "<h1>Login page</h1>\n" +
                "<p>Example user: user / password</p>\n" +
                "<form action=\"/login\" method=\"post\">\n" +
                "    <label for=\"username\">Username</label>:\n" +
                "    <input type=\"text\" id=\"username\" name=\"username\" autofocus=\"autofocus\" /> <br />\n" +
                "    <label for=\"password\">Password</label>:\n" +
                "    <input type=\"password\" id=\"password\" name=\"password\" /> <br />\n" +
                "    <input type=\"submit\" value=\"Log in\" />\n" +
                "</form>\n" +
                "<p><a href=\"/\">Back to home page</a></p>\n" +
                "</body>";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView hasLogin() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/");
        return model;
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }
}
