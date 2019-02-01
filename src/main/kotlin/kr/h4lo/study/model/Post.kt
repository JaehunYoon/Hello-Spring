package kr.h4lo.study.model

data class Post (val id: Int,
                 val title: String,
                 val content: String,
                 val comment: List<Comment>?,
                 val createdAt: String)