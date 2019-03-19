package kr.h4lo.study.controller

import kr.h4lo.study.model.Comment
import kr.h4lo.study.model.Post
import kr.h4lo.study.repository.PostRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*

@RestController
@RequestMapping("/posts")
class PostController (val postRepository: PostRepository) {
    @GetMapping
    fun getPosts() = postRepository.findAll()

    @RequestMapping(path = ["/{postId}"], method = [RequestMethod.GET])
    fun getPost(@PathVariable("postId") postId: Int): Optional<Post> {
        return postRepository.findById(postId)
    }

    @PostMapping
    fun newPost(@RequestBody post: Post): Post {
        postRepository.save(post)
        return post
    }

    @RequestMapping(path = ["/{postId}"], method = [RequestMethod.PATCH])
    @ResponseStatus(HttpStatus.OK)
    fun updatePost(@PathVariable("postId") postId: Int, @RequestBody post: Post) {
        var target: Post = postRepository.findById(postId).get()
        target.title = post.title
        target.content = post.content

        postRepository.save(target)
    }

    @RequestMapping(path = ["/{postId}"], method = [RequestMethod.DELETE])
    fun deletePost(@PathVariable("postId") postId: Int) {
        postRepository.deleteById(postId)
    }
//    @RequestMapping("posts/{id}", method = [RequestMethod.GET])
//    fun getPost(@PathVariable id: Int): String {
//        return "test.$id"
//    }
//
//    @RequestMapping("posts/{id}", method = [RequestMethod.POST])
//    fun createPost(@PathVariable id: Int): Post {
//        val title = "test title"
//        val content = "test content"
//        val currentTime = getCurrentTime()
//
//        return Post(id, "test", "test", listOf(Comment("commenter", "content", currentTime), Comment("foo", "bar", currentTime)), currentTime)
//    }
//
//    @RequestMapping("posts/{id}", method = [RequestMethod.PATCH])
//    fun updatePost(@PathVariable id: Int): Post {
//        val currentTime = getCurrentTime()
//        return Post(id, "update", "update", listOf(Comment("update", "update", currentTime), Comment("update", "update", currentTime)), currentTime)
//    }
//
//    @RequestMapping("posts/{id}", method = [RequestMethod.DELETE])
//    fun deletePost(@PathVariable id: Int): String {
//        return "delete"
//    }


//    Custom Function
    fun getCurrentTime() = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(Instant.now())!!
}