package kr.h4lo.study

import kr.h4lo.study.model.User
import kr.h4lo.study.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit4.SpringRunner
import javax.persistence.EntityManager

@RunWith(SpringRunner::class)
@DataJpaTest(showSql = true)
open class Demo {
    @Autowired lateinit var userRepository: UserRepository
    @Autowired lateinit var entityManager: EntityManager

    @Before
    fun setup() {
        userRepository.save(User(name="alice"))
        userRepository.save(User(name="bob"))
        entityManager.clear()
    }

    @Test
    fun simple() {
        println(userRepository.findByName("bob"))
    }
}