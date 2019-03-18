package kr.h4lo.study.model

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class User(@Id
                @GeneratedValue(strategy = GenerationType.AUTO)
                var id: Int? = null,
                var name: String)