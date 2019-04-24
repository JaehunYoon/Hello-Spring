package kr.h4lo.study.model

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "accounts")
data class Account (@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    var id: Int? = null,
                    @Column(nullable = false, unique = true)
                    @Size(min = 3, max = 255)
                    var userId : String,
                    @Size(min = 8)
                    @Column(nullable = false)
                    var password: String,
                    var nickname: String)