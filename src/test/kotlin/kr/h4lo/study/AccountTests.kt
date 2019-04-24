package kr.h4lo.study

import kr.h4lo.study.model.Account
import kr.h4lo.study.model.Role
import kr.h4lo.study.repository.AccountRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AccountTests (val accountRepository: AccountRepository) {
    @Test
    fun insertTest() {
        for (i in 0..99) {
            var account: Account? = null
            account!!.let {
                it.userId = "user$i"
                it.password = "password$i"
                it.nickname = "nickname$i"
            }

            var role: Role? = null
            if (i <= 80) {
                role?.roleName = "STUDENT"
            } else {
                role?.roleName = "ADMIN"
            }
            // account.setRoles(Arrays.asList(role));
            account?.let { accountRepository.save(it) }
        }
    }
}