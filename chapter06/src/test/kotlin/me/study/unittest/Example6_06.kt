package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDateTime
import org.junit.jupiter.api.Test

class Example6_06_kt {

    @Test
    @Throws(Exception::class)
    fun addingACommentToAnArticle() {
        // Given
        val sut = Article()
        val comment = Comment(
            "Comment text",
            "John Doe",
            LocalDateTime.now()
        )

        // When
        sut.addComment(comment.text, comment.author, comment.dateCreated)

        // Then
        assertThat(sut.comments()).containsExactly(comment)
    }
}