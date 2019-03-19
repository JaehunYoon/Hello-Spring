package kr.h4lo.study.model

import javax.persistence.*

//data class Post (val id: Int,
//                 val title: String,
//                 val content: String,
//                 val comment: List<Comment>?,
//                 val createdAt: String)

@Entity
@Table(name = "posts")
data class Post (@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 @Column(name = "post_id")
                 val id: Int,
                 @Column(nullable = false)
                 val title: String,
                 @Column(nullable = false)
                 val content: String,
                 @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
                 val comment: List<Comment>?,
                 @Column(nullable = false)
                 val createdAt: String)