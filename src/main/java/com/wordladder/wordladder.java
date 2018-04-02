package com.wordladder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.FileNotFoundException;

@RestController
public class wordladder {
    @RequestMapping("/")
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
}
