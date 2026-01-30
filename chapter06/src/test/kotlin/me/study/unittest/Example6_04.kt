package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import java.time.LocalDateTime
import org.junit.jupiter.api.Test

class Example6_04_kt {

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
        assertThat(sut.comments().size).isEqualTo(1)
        assertThat(sut.comments()[0].text).isEqualTo(text)
        assertThat(sut.comments()[0].author).isEqualTo(author)
        assertThat(sut.comments()[0].dateCreated).isEqualTo(now)
    }
}