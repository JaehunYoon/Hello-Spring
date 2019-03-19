package kr.h4lo.study.model

import javax.persistence.*

data class Post (val id: Int,
                 val title: String,
                 val content: String,
                 val comment: List<Comment>?,
                 val createdAt: String)