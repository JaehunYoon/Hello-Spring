package kr.h4lo.study.repository

import kr.h4lo.study.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Int> {
    fun findByName(name: String): User?
}