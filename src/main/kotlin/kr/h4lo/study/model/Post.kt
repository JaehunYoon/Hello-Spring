package kr.h4lo.study.model

import org.hibernate.annotations.CreationTimestamp
import java.util.*
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
                 var id: Int,
                 @Column(nullable = false)
                 var title: String,
                 @Column(nullable = false)
                 var content: String,
//                 @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
//                 val comment: List<Comment>? = ArrayList(),
                 @CreationTimestamp
//                 @DateTimeFormat
                 var createdAt: Date?)