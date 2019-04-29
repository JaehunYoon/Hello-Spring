package kr.h4lo.study.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class LoginController {
    @RequestMapping(path = ["/login"], method = [RequestMethod.GET])
    fun loginForm(req: HttpServletRequest): String {
        val referer: String = req.getHeader("Referer")
        req.session.setAttribute("prevPage", referer)
        return "login"
//      템플릿 엔진 개발이었다면, thymeleaf 를 통해 로그인 폼으로 연결됨.
    }
}