package kr.h4lo.study.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Role (@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 var rno: Int?,
                 var roleName: String?)