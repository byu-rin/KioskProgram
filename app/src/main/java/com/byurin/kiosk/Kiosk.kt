package com.byurin.kiosk

import java.util.Scanner

fun main() {
    println("Welcome to Store. Press the Category number.")
    category()
    quantity()
    togo()
    val userQuantity = quantity()
    payment(userQuantity)
}

fun category() {
    val category = listOf("1. Coffee", "2. Ade", "3. Tea")
    println(category.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    when(scanner) {
        1 -> orderCoffee()
        2 -> orderAde()
        3 -> orderTea()
        else -> println("Please enter a valid number")
    }
}

fun orderCoffee() {
    val coffee = mutableMapOf(
        "1. Americano" to 2000,
        "2. Latte" to 2500,
        "3. Espresso" to 1500
    )
    println(coffee.entries.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    when (scanner) {
        1 -> println(coffee.keys.elementAt(0))
        2 -> println(coffee.keys.elementAt(1))
        3 -> println(coffee.keys.elementAt(2))
        else -> println("Please enter a valid number")
    }
    temperature()
}

fun orderAde() {
    val ade = mutableMapOf(
        "Strawberry Ade" to 2500,
        "Lemon Ade" to 2500,
        "Mint Ade" to 3000
    )
    println(ade.entries.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    when (scanner) {
        1 -> println(ade.keys.elementAt(0))
        2 -> println(ade.keys.elementAt(1))
        3 -> println(ade.keys.elementAt(2))
        else -> println("Please enter a valid number")
    }
}

fun orderTea() {
    val tea = mutableMapOf(
        "Lemon Tea" to 2000,
        "Camomile Tea" to 2000,
        "Green Tea" to 2000
    )
    println(tea.entries.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    when (scanner) {
        1 -> println(tea.keys.elementAt(0))
        2 -> println(tea.keys.elementAt(1))
        3 -> println(tea.keys.elementAt(2))
        else -> println("Please enter a valid number")
    }
}

fun temperature(): Boolean {
    println("1. Ice\n2. Hot")

    val scanner = Scanner(System.`in`).nextInt()

    return if (scanner == 1) {
        true
    } else {
        false
    }
}

fun quantity(): Int {
    println("Please enter the quantity. ex) 2")
    val scanner = Scanner(System.`in`).nextInt()
    return scanner
}

fun togo(): Boolean {
    println("1. to-go\n2. here")

    val scanner = Scanner(System.`in`).nextInt()

    return if (scanner == 1) {
        true
    } else {
        false
    }
}

fun payment(quantity: Int) {
    println("You ordered ${quantity}.")
}