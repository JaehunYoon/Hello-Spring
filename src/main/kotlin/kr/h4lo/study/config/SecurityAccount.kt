package kr.h4lo.study.config

import kr.h4lo.study.model.Account
import kr.h4lo.study.model.Role
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

class SecurityAccount(account: Account) : User(account.userId, account.password, account.roles?.let { makeGrantedAuthority(it) }) {
    companion object {
        val ROLE_PREFIX = "ROLE_"
        private val serialVersionId = 1

        private fun makeGrantedAuthority(roles: List<Role>): MutableList<GrantedAuthority> {
            val list: MutableList<GrantedAuthority> = ArrayList()
            roles.forEach {
                role -> list.add(SimpleGrantedAuthority(ROLE_PREFIX + role.roleName))
            }
            return list
        }
    }
}