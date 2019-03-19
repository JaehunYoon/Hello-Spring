package kr.h4lo.study.model

import javax.persistence.*

@Entity
@Table(name = "todo")
data class Todo (@Id
                 @GeneratedValue(strategy = GenerationType.IDENTITY)
                 @Column(columnDefinition = "serial")
                 var id: Long? = null,

                 var title: String? = null,
                 var description: String? = null,
                 var finished: Boolean? = false)