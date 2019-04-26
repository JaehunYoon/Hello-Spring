package kr.h4lo.study.controller

import kr.h4lo.study.model.Account
import kr.h4lo.study.model.Role
import kr.h4lo.study.repository.AccountRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterController (val accountRepository: AccountRepository) {
    @RequestMapping(path = ["/register"], method = [RequestMethod.POST], consumes = ["application/json"])
    fun createAccount(@RequestBody account: Account,
                      passwordEncoder: BCryptPasswordEncoder,
                      role: Role) {
        account.password = passwordEncoder.encode(account.password)
        role.roleName = "STUDENT"
        account.roles = listOf(role)
        accountRepository.save(account)
    }
}