package me.study.unittest

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Example4_4_kt {

    @Test
    @Throws(Exception::class)
    fun renderingAMessage() {
        // Given
        val sut = MessageRenderer()
        val message = Message()
        message.header = "h"
        message.body = "b"
        message.footer = "f"

        // When
        val html = sut.render(message)

        // Then
        Assertions.assertThat(html).isEqualTo("<h1>h</h1><b>b</b><i>f</i>")
    }
}