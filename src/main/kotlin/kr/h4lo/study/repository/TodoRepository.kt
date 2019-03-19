package kr.h4lo.study.repository

import kr.h4lo.study.model.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long>