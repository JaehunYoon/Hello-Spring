package kr.h4lo.study.model

import javax.persistence.*

//data class Comment (val commenter: String,
//                    val content: String,
//                    val createdAt: String)

@Entity
@Table(name = "comments")
data class Comment (@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    val id: Int,
                    @Column(nullable = false)
                    val commenter: String,
                    @Column(nullable = false)
                    val content: String,
                    @Column(nullable = false)
                    val createdAt: String,
                    @ManyToOne(fetch = FetchType.EAGER)
                    @JoinColumn(name = "post_id")
                    val post: Post)