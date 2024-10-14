package com.byurin.kiosk

import java.util.Scanner

abstract class User(val username: String, private val password: Int) {
    abstract fun performAction()

    fun validatePassword(inputPassword: Int): Boolean {
        return password == inputPassword
    }
}

class Customer(username: String, password: Int) : User(username, password) {
    override fun performAction() {
        println("customer mode")
    }
    // 주문
}

class Manager(username: String, password: Int) : User(username, password) {
    override fun performAction() {
        println("Manager mode")
    }
    // 개점, 마감, 관리
}

class AuthenticationService {
    private val users = listOf(
        Customer("customer", 1111),
        Manager("manager", 2222)
    )

    fun login(username: String, password: Int): User? {
        val user = users.find { it.username == username }

        return if (user != null && user.validatePassword(password)) {
            user
        } else {
            null
        }
    }
}

fun main() {
    val sc: Scanner = Scanner(System.`in`)
    val authService = AuthenticationService()

    println("input user name: ")
    val username = sc.nextLine() ?: return

    println("input user pw: ")
    val password = sc.nextLine().toInt() ?: return

    val loggedInUser = authService.login(username, password)

    loggedInUser?.performAction() ?: println("false! invalid name or password.")

}