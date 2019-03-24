package kr.h4lo.study.controller

import kr.h4lo.study.model.Post
import kr.h4lo.study.repository.PostRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
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
}