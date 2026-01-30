package me.study.unittest

import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito.mock
import java.time.LocalDateTime
import org.junit.jupiter.api.Test

class Example6_11_kt {

    @Test
    @Throws(Exception::class)
    fun aNewFileIsCreatedWhenTheCurrentFileOverflows() {
        // Given
        val directoryName = "audits"
        val fileSystemMock = mock(IFileSystem::class.java)
        given(fileSystemMock.getFiles(directoryName)).willReturn(
            listOf("audits/audit_1.txt", "audits/audit_2.txt")
        )
        given(fileSystemMock.readAllLines("audits/audit_2.txt")).willReturn(
            listOf("Peter; 2019-04-06T16:30:00", "Jane; 2019-04-06T16:40:00", "Jack; 2019-04-06T17:00:00")
        )
        val sut = AuditManager_V2(3, directoryName, fileSystemMock)

        // When
        sut.addRecord("Alice", LocalDateTime.parse("2019-04-06T18:00:00"))

        // Then
        then(fileSystemMock).should().writeAllText("audits/audit_3.txt", "Alice;2019-04-06T18:00:00")
    }
}