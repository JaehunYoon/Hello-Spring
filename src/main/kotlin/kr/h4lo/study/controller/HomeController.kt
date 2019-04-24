package kr.h4lo.study.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HomeController {
    @GetMapping
    fun home(): String = "Home"

    @RequestMapping(path = ["admin"], method = [RequestMethod.GET])
    fun admin(): String = "Admin Page"
}