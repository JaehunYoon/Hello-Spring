package kr.h4lo.study.repository

import kr.h4lo.study.model.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Int>