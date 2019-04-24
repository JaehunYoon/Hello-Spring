package kr.h4lo.study.repository

import kr.h4lo.study.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Int> {
}