package kr.h4lo.study.repository

import kr.h4lo.study.model.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Int>