package com.byurin.kiosk

interface ReceiptAction {
    fun orderReceipt(value: Int): String
}
interface OrderAction {
    fun orderMenu(value: Int): Pair<String, Int>
}

abstract class Order : OrderAction {
//    protected var selectedReceipt: String = ""
    protected var selectionMenu = Pair("", 0)

    // 메뉴 선택 로직을 제공하지만, 구체적인 메뉴는 하위 클래스에서 재정의
    override fun orderMenu(value: Int): Pair<String, Int> {
        val menu = getMenuList()
        selectionMenu = menu.getOrElse(value - 1) {
            throw IllegalArgumentException("Invalid number")
        }
        return selectionMenu
    }

    // 하위 클래스에서 제공해야 하는 메뉴 리스트
    abstract fun getMenuList(): List<Pair<String, Int>>
}

class ReceiptOrder : ReceiptAction {
    override fun orderReceipt(value: Int): String {
        return when (value) {
            1 -> "to-go"
            2 -> "for here"
            else -> throw IllegalArgumentException("Invalid number")
        }
    }
}

class MenuOrder : Order() {
    override fun getMenuList(): List<Pair<String, Int>> {
        return listOf(
            "coffee" to 2000,
            "ade" to 2500,
            "tea" to 2500
        )
    }
}

fun main() {
    val receiptOrder = ReceiptOrder()
    println("Receipt: " + receiptOrder.orderReceipt(1))

    val menuOrder = MenuOrder()
    val selectedMenu = menuOrder.orderMenu(2)
    println("Selected Menu : ${selectedMenu.first}, Price: ${selectedMenu.second}")

}