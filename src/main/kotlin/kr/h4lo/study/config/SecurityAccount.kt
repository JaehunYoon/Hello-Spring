package kr.h4lo.study.config

import kr.h4lo.study.model.Account
import kr.h4lo.study.model.Role
import org.springframework.boot.autoconfigure.security.SecurityProperties.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

class SecurityAccount(account: Account) : User(account.id, account.password, makeGrantedAutority(account.roles)) {
    companion object {
        private val ROLE_PREFIX = "ROLE_"
        private val serialVersionId = 1

        private fun makeGrantedAutority(roles: List<Role>) : List<GrantedAuthority> {
            val list = ArrayList()
            roles.forEach {
                role -> list.add(SimpleGrantedAuthority(ROLE_PREFIX + role.roleName))
            }
        }
    }
}