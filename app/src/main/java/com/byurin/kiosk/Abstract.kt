package com.byurin.kiosk

interface SystemControl {
//    fun back() {
//        back()
//    }

    fun keep() {
        TODO("계속 하기")
    }

    fun reset() {
        TODO("초기화")
    }

    fun add()
    fun delete()
}

open class Order() {
    protected var selected_receipt : String = orderReceipt(1)
    protected var selected_menus : Pair<String, Int> = orderMenu(1)

    open fun orderReceipt(value: Int) : String {
        println("Select Order route.\n 1. to-go\n 2. for here")

       val a = when (value) {
            1 -> "to-go"
            2 -> "for here"
            else -> {
                throw IllegalArgumentException("invalid number")
            }
        }
        println("order_receipt : $a")
        return a
    }

    open fun orderMenu(value: Int) : Pair<String, Int> {
        val menu = arrayListOf("coffee" to 2000, "ade" to 2500, "tea" to 2500)
        println("Select Menu.$menu")

        selected_menus = when(value) {
            1 -> menu[1]
            2 -> menu[2]
            3 -> menu[3]
            else -> {
                throw IllegalArgumentException("invalid number")
            }
        }
        println("order menu : ${menu[value-1]}")
        return selected_menus
    }

    open fun orderQuantity(value: Int) {
        println("Select order quantity. You can do up to 10.")
        if (value in 1..10) {
            println("order quantity : $value")
        } else {
            throw IllegalArgumentException("invalid number")
        }
    }
}

class OrderReceipt() : Order() {
    override fun orderReceipt(value: Int) : String {
        return super.orderReceipt(value)
    }

    fun printSelectedReceipt() {
        if (selected_receipt != null) {
            println("${selected_receipt}")
        } else {
            println("System Error")
        }
    }
}

class OrderMenu() : Order() {
    override fun orderMenu(value: Int) : Pair<String, Int> {
        return super.orderMenu(value)
    }

    fun printSelectedMenu() {
        if (selected_menus != null) {
            println("$selected_menus")
        } else {
            println("System Error")
        }
    }
}

class OrderQuantity() : Order() {
    override fun orderQuantity(value: Int) {
        return super.orderQuantity(value)
    }
}

fun main() {
    val orderReceipt = OrderReceipt()
    val orderMenu = OrderMenu()
    println()
    orderReceipt.printSelectedReceipt()
    orderMenu.printSelectedMenu()
//    println()
//    OrderQuantity().orderQuantity(3)


}