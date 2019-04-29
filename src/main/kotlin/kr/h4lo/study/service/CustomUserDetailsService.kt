package kr.h4lo.study.service

import kr.h4lo.study.repository.AccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService (val accountRepository: AccountRepository) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(userId: String?): UserDetails? {
//        return Optional.ofNullable(accountRepository.findByUserId(userId)).map()
        return null
    }
}