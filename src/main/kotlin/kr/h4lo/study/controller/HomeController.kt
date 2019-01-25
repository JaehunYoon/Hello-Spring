package kr.h4lo.study.controller

import kr.h4lo.study.model.Greeting
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping(value = ["/"], method = [RequestMethod.GET])
class HomeController {

    val counter = AtomicLong()

    @GetMapping("/")
    fun index(): String = "hi~~~"

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello $name")
}