package kr.h4lo.study.controller

import kr.h4lo.study.model.Comment
import kr.h4lo.study.model.Post
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class HomeController {

    @GetMapping("/")
    fun home(): String = "Home"

    @GetMapping("posts")
    fun getPosts(): String = "test"

    @RequestMapping("posts/{id}", method = [RequestMethod.GET])
    fun getPost(@PathVariable id: Int): String {
        return "test.$id"
    }

    @RequestMapping("posts/{id}", method = [RequestMethod.POST])
    fun post(@PathVariable id: Int): Post {
        return Post(id, "test", "test", listOf(Comment("commenter", "content"), Comment("foo", "bar")))
    }
}