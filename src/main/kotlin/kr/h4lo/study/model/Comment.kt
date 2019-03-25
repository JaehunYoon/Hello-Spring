package kr.h4lo.study.model

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "comments")
data class Comment (@Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    val id: Int,
                    @Column(nullable = false)
                    val commenter: String,
                    @Column(nullable = false)
                    var content: String,
                    @CreationTimestamp
                    val createdAt: Date?,
                    @ManyToOne(fetch = FetchType.LAZY, optional = false)
                    @JoinColumn(name = "post_id", nullable = false)
                    @OnDelete(action = OnDeleteAction.CASCADE)
                    var post: Post?)