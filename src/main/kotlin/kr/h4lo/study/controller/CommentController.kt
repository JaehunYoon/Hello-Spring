package kr.h4lo.study.controller

import kr.h4lo.study.model.Comment
import kr.h4lo.study.repository.CommentRepository
import kr.h4lo.study.repository.PostRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/posts")
class CommentController (val commentRepository: CommentRepository,
                         val postRepository: PostRepository) {
    @RequestMapping(path = ["/{postId}/comments"], method = [RequestMethod.GET])
    fun getComments(@PathVariable("postId") postId: Int) {
// 댓글을 불러오는 기능 구현
    }

    @RequestMapping(path = ["/{postId}/comments"], method = [RequestMethod.POST])
    fun newComment(@PathVariable("postId") postId: Int,
                   @RequestBody comment: Comment): Optional<Comment>? {
        return postRepository.findById(postId).map {
            comment.post = it
            commentRepository.save(comment)
        }
    }

    @RequestMapping(path = ["/posts/comments/{commentId}"], method = [RequestMethod.PATCH])
    @ResponseStatus(HttpStatus.OK)
    fun updateComment(@PathVariable("commentId") commentId: Int,
                      @RequestBody comment: Comment) {
        commentRepository.findById(commentId).map {
            it.content = comment.content
            commentRepository.save(it)
        }
    }

    @RequestMapping(path = ["/posts/comments/{commentId}"], method = [RequestMethod.DELETE])
    fun deleteComment(@PathVariable("commentId") commentId: Int) {
        commentRepository.deleteById(commentId)
    }
}