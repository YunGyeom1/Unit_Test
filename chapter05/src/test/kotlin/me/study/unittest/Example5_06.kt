package me.study.unittest

class Example5_06_kt {

    class User {

        private var name: String = ""

        fun getName(): String {
            return name
        }

        fun setName(name: String) {
            this.name = normalizeName(name)
        }

        fun normalizeName(name: String): String {
            val result = name.trim()

            return if (result.length > 50) {
                result.substring(0, 50)
            } else {
                result
            }
        }
    }

    class UserController {

        fun renameUser(userId: Int, newName: String) {
            val user = getUserFromDatabase(userId)
            user.setName(newName)
            saveUserToDatabase(user)
        }

        private fun saveUserToDatabase(user: User) {
            // Saving user logic
        }

        private fun getUserFromDatabase(userId: Int): User {
            return User()
        }
    }
}