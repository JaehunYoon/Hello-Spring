package kr.h4lo.study.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Account (@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    var id: Int? = null,
                    var userId : String,
                    var password: String,
                    var nickname: String)