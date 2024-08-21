package com.byurin.kiosk

import java.util.Scanner

fun main() {
    println("Welcome to Store. Press the Category number.")
    // 변수 선언
    val selectedItem = category()
    val selectedTemperature = if (selectedItem.first == "Coffee") temperature() else null
    val selectedQuantity = quantity()
    val isTogo = togo()

    payment(selectedItem.second, selectedTemperature, selectedQuantity, isTogo)
}

fun category(): Pair<String, String> {
    val category = listOf("1. Coffee", "2. Ade", "3. Tea")
    println(category.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    return when(scanner) {
        1 -> orderCoffee()
        2 -> orderAde()
        3 -> orderSmoothie()
        else -> {
            println("Please enter a valid number")
            category()
        }
    }
}

fun orderCoffee(): Pair<String, String> {
    val coffee = mutableMapOf(
        "1. Americano" to 2000,
        "2. Latte" to 2500,
        "3. Espresso" to 1500
    )
    println(coffee.entries.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    return when (scanner) {
        1 -> "Coffee" to "Americano"
        2 -> "Coffee" to "Latte"
        3 -> "Coffee" to "Espresso"
        else -> {
            println("Please enter a valid number")
            orderCoffee()
        }
    }
    temperature()
}

fun orderAde(): Pair<String, String> {
    val ade = mutableMapOf(
        "Strawberry Ade" to 2500,
        "Lemon Ade" to 2500,
        "Mint Ade" to 3000
    )
    println(ade.entries.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    return when (scanner) {
        1 -> "Ade" to "Strawberry Ade"
        2 -> "Ade" to "Lemon Ade"
        3 -> "Ade" to "Mint Ade"
        else -> {
            println("Please enter a valid number")
            orderAde()
        }
    }
}

fun orderSmoothie(): Pair<String, String> {
    val tea = mutableMapOf(
        "Banana Smoothie" to 4000,
        "Milk Smoothie" to 4000,
        "Mango Smoothie" to 4000
    )
    println(tea.entries.joinToString("\n"))
    val scanner = Scanner(System.`in`).nextInt()

    return when (scanner) {
        1 -> "Smoothie" to "Banan Smoothie"
        2 -> "Smoothie" to "Milk Smoothie"
        3 -> "Smoothie" to "Mango Smoothie"
        else -> {
            println("Please enter a valid number")
            orderSmoothie()
        }
    }
}

fun temperature(): String {
    println("1. Ice\n2. Hot")

    val scanner = Scanner(System.`in`).nextInt()

    return if (scanner == 1) {
        "Ice"
    } else {
        "Hot"
    }
}

fun quantity(): Int {
    println("Please enter the quantity. ex) 2")
    val scanner = Scanner(System.`in`).nextInt()
    return scanner
}

fun togo(): String {
    println("1. to-go\n2. here")

    val scanner = Scanner(System.`in`).nextInt()

    return if (scanner == 1) {
        "to-go"
    } else {
        "here"
    }
}

fun payment(item: String, temperature: String?, quantity: Int, togo: String) {
    println("\n--- Payment Details ---")
    println("Item: $item")
    temperature?.let { println("Temperature: $it") }
    println("Quantity: $quantity")
    println("Takeout Option: $togo")
}