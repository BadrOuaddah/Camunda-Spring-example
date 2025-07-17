package com.example.workflow;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class Controller {
    java.util.logging.Logger logger = java.util.logging.Logger.getLogger(this.getClass().getName());

    @PostMapping("/message")
    public Model createMessage(@RequestBody Model model){
        logger.info("-------Message Creator Initialized-------");

        Model m = new Model();
        m.setName(model.getName());
        m.setMessage(model.getMessage());

        logger.info("Message created --> " + m.toString());
        return m;
    }
}
