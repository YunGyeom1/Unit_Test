package me.study.unittest

import org.junit.jupiter.api.Test

class Example1_3_kt {

    companion object {
        fun isStringLong(input: String): Boolean {
            return input.length > 5
        }
    }

    @Test
    fun test() {
        // Kotlin에서는 변수 타입을 추론하므로 Boolean 명시를 생략해도 됩니다.
        val result1 = isStringLong("abc")
        val result2 = isStringLong("abcdef")
    }
}