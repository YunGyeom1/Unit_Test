package me.study.unittest

class Example5_05_kt {

    class User {

        var name: String = ""

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
            val normalizedName = user.normalizeName(newName)
            user.name = normalizedName
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