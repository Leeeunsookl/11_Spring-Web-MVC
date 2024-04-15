package com.ohgiraffers.requestmapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodMappingTestController {

    /* 1.메소드 방식 미지정 */
    @RequestMapping("/menu/regist")
    public String registMenu(Model model) {


        model.addAttribute("message",
                "신규 메뉴 등록용 핸들러 메소드 호출됨... ");

        /* 필기.
        *   Thymeleaf 의존성을 추가하게 되면
        *   ThymeleafViewResolver 라는 녀석이 생기게 된다.
        *   접두사 /resource/templates
        *   접미사 .html
        *  */

        return "mappingResult";
    }

}
