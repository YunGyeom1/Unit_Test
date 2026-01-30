package me.study.unittest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Example4_2_kt {

    @Test
    @Throws(Exception::class)
    fun messageRendererUsesCorrectSubRenderers() {
        // Given
        val sut = MessageRenderer()

        // When
        val renderers = sut.getSubRenderers()

        // Then
        assertThat(renderers.size).isEqualTo(3)
        assertThat(renderers[0]).isInstanceOf(HeaderRenderer::class.java)
        assertThat(renderers[1]).isInstanceOf(BodyRenderer::class.java)
        assertThat(renderers[2]).isInstanceOf(FooterRenderer::class.java)
    }
}