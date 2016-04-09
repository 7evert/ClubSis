package com.clubsis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sebastian on 09-Apr-16.
 */

@Controller
public class ClubController {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
