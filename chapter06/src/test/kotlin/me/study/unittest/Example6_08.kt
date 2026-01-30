package me.study.unittest

import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Example6_08_kt {

    @Test
    @Throws(IOException::class)
    fun addRecord() {
        val visitorName = "Jinseong2"
        val timeOfVisit = LocalDateTime.now()

        // 상대 경로로 디렉토리 설정
        val dirPath = "src/test/me/study/unittest/data"
        val dir = File(dirPath)

        // 디렉토리가 없다면 생성
        if (!dir.exists()) {
            val created = dir.mkdirs() // 디렉토리 생성
            if (created) {
                println("디렉토리 생성됨: $dirPath")
            } else {
                throw IllegalStateException("디렉토리 생성 실패: $dirPath")
            }
        }

        // 파일 목록 가져오기
        val filePaths = dir.listFiles()?.map { it.path } ?: emptyList()
        val sorted = sortByIndex(filePaths)

        val newRecord = "${visitorName};${timeOfVisit.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"))}"

        // 새로운 파일 생성
        if (sorted.isEmpty()) {
            val newFile = File("${dir.path}/audit_1.txt")
            if (newFile.createNewFile()) {
                FileWriter(newFile).use { fileWriter ->
                    fileWriter.write(newRecord)
                }
                return
            } else {
                throw IllegalStateException("\"audit_1.txt\" named file already exists.")
            }
        }

        val latestFile = sorted.last()
        val currentFileIndex = latestFile.key
        val currentFilePath = latestFile.value

        val lines = Files.readAllLines(Path.of(currentFilePath))

        // 파일이 2개 미만이라면 같은 파일에 기록
        if (lines.size < 2) {
            FileWriter(currentFilePath).use { fileWriter ->
                lines.add(newRecord)
                fileWriter.write(lines.joinToString("\r\n"))
            }
        } else {
            // 새 파일 생성
            val newIndex = currentFileIndex + 1
            val newName = "audit_$newIndex.txt"
            val newFile = File("${dir.path}/$newName")
            if (newFile.createNewFile()) {
                FileWriter(newFile).use { fileWriter ->
                    fileWriter.write(newRecord)
                }
            }
        }
    }

    private fun sortByIndex(files: List<String>): List<Map.Entry<Int, String>> {
        val map = mutableMapOf<Int, String>()
        files.forEachIndexed { i, file -> map[getIndex(file)] = file }

        return map.entries.sortedBy { it.key }
    }

    private fun getIndex(filePath: String): Int {
        val underscoreIdx = filePath.lastIndexOf("_")
        val dotIdx = filePath.lastIndexOf(".")
        return filePath.substring(underscoreIdx + 1, dotIdx).toInt()
    }
}