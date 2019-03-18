package kr.h4lo.study.repository

import kr.h4lo.study.model.Post
import org.springframework.data.repository.CrudRepository

interface PostRepository : CrudRepository<Post, Int> {
}