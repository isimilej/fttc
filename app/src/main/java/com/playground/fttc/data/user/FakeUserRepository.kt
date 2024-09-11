package com.playground.fttc.data.user

import com.playground.fttc.domain.user.LoginResult
import com.playground.fttc.domain.user.User
import com.playground.fttc.domain.user.UserRepository

class FakeUserRepository : UserRepository {

    private val users = listOf(User("kwangjin", "임광진", "1111"))

    override fun login(userId: String, password: String): LoginResult {
        users.forEach {
            if (it.id == userId) {
                return if (it.password == password)
                    LoginResult.Success(it)
                else
                    LoginResult.Fail.NotMatched
            }
        }
        return LoginResult.Fail.NotFoundUser
    }
}