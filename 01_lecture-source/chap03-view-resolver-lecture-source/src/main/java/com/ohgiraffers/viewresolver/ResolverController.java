package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class ResolverController {

    @GetMapping("string")
    public String stringReturning(Model model) {

        model.addAttribute("forwardMessage", "문자열로 뷰 이름 반환함..");

        /* 필기.
        *   문자열로 뷰 이름을 반환한다는 것은 반환 후
        *   ThymeleafViewResolver 에게 너가 앞에 resources/template 붙이고
        *   뒤에는 .html 붙여 라는 의미로 해석할 수 있다.
        *  */

        return "result";
    }

    @GetMapping("string-redirect")
    public String stringRedirect() {

        /* 접두사로 redirect: 을 하면 forward 방식이 아닌
        *   redirect 를 시켜준다.
        *  */
        return "redirect:/";
    }

    /* 필기.
    *   redirect 일어난다 -> 재요청이 발생하기 대문에 request 의 scope 는 소멸된다.
    *   하지만 스프링에서는 RedirectAttributes 타입을 통해 redirect 시 속성 값을
    *   저장할 수 있도록 하는 기능을 제공한다.
    *  */
    @GetMapping("string-redirect-attr")
    public String stringRedirectFlashAttr() {

    }

}
