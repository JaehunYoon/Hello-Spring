package kr.h4lo.study.model

import javax.persistence.*

@Entity
data class Post (@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 val id: Int,
                 @Column(nullable = false)
                 val title: String,
                 @Column(nullable = false)
                 val content: String,
                 @Column(nullable = true)
                 val comment: List<Comment>?,
                 @Column(nullable = false)
                 val createdAt: String)