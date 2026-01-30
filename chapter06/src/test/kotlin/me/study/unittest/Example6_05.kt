package me.study.unittest

import java.time.LocalDateTime
import org.junit.jupiter.api.Test
import me.study.unittest.ArticleExtensions.shouldContainNumberOfComments
import me.study.unittest.ArticleExtensions.withComment

class Example6_05_kt {

    @Test
    @Throws(Exception::class)
    fun addingACommentToAnArticle() {
        // Given
        val sut = Article()
        val text = "Comment text"
        val author = "John Doe"
        val now = LocalDateTime.now()

        // When
        sut.addComment(text, author, now)

        // Then
        shouldContainNumberOfComments(sut, 1)
        withComment(sut, text, author, now)
    }
}