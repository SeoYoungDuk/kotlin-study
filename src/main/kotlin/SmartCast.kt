import kotlin.IllegalArgumentException

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

//fun eval(e: Expr): Int {
//    if (e is Num) {
//        val n = e as Num
//        return n.value
//    }
//    if (e is Sum) {
//        return eval(e.right) + eval(e.left)
//    }
//
//    throw IllegalArgumentException("Unknown expression");
//}

fun eval(e: Expr): Int {
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }

    throw IllegalArgumentException("Unknown expression");
}

fun evalWithLogging(e: Expr): Int {
    when(e) {
        is Num -> {
            println("num : ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum : $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }

    throw IllegalArgumentException("Unknown expression");
}

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}