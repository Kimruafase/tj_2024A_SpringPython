package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {

    //  [1] 채팅 관련 템플릿 매핑
    @GetMapping("/chat")
    public String chat() {
        return "/chat/chat.html";
    }

}
