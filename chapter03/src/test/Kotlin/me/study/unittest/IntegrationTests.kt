package me.study.unittest

abstract class IntegrationTests_kt {

    protected val database: Database = Database()

    fun dispose() {
        database.dispose()
    }
}