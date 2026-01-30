package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDateTime

object ArticleExtensions_kt {

    fun shouldContainNumberOfComments(article: Article, commentCount: Int) {
        assertThat(article.comments().size).isEqualTo(1)
    }

    fun withComment(article: Article, text: String, author: String, dateCreated: LocalDateTime) {
        val comments = article.comments()
        val comment = getSingleOrDefault(comments, text, author, dateCreated)
        assertThat(comment).isNotNull()
    }

    private fun getSingleOrDefault(comments: List<Comment>, text: String, author: String, dateCreated: LocalDateTime): Comment {
        if (comments.size > 1) {
            throw IllegalStateException()
        }
        return if (comments.isEmpty()) {
            Comment(text, author, dateCreated)
        } else {
            comments[0]
        }
    }
}