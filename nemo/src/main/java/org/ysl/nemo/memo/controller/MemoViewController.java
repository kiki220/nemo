package org.ysl.nemo.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemoViewController {
    
    @GetMapping("/")
    public String view(HttpSession session) {
        if(session.getAttribute("userID") != null) {
            return "memo/html/index.html";
        }
        return "redirect:/login";
    }
}
