package kr.h4lo.study.controller

import kr.h4lo.study.model.Comment
import kr.h4lo.study.model.Post
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/")
class PostController {
    @Autowired
    private lateinit var template: JdbcTemplate

    @GetMapping("posts")
    fun getPosts(): String = "test"

    @RequestMapping("posts/{id}", method = [RequestMethod.GET])
    fun getPost(@PathVariable id: Int): String {
        return "test.$id"
    }

    @RequestMapping("posts/{id}", method = [RequestMethod.POST])
    fun createPost(@PathVariable id: Int): Post {
        val currentTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(Instant.now())
        return Post(id, "test", "test", listOf(Comment("commenter", "content", currentTime), Comment("foo", "bar", currentTime)), currentTime)
    }

    @RequestMapping("posts/{id}", method = [RequestMethod.PATCH])
    fun updatePost(@PathVariable id: Int): Post {
        val currentTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(Instant.now())
        return Post(id, "update", "update", listOf(Comment("update", "update", currentTime), Comment("update", "update", currentTime)), currentTime)
    }

    @RequestMapping("posts/{id}", method = [RequestMethod.DELETE])
    fun deletePost(@PathVariable id: Int): String {
        return "delete"
    }
}