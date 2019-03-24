package kr.h4lo.study.model

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "posts")
data class Post (@Id
                 @GeneratedValue(strategy = GenerationType.AUTO)
                 @Column(name = "post_id")
                 var id: Int,
                 @Column(nullable = false)
                 var title: String,
                 @Column(nullable = false)
                 var content: String,
                 @CreationTimestamp
                 var createdAt: Date?)