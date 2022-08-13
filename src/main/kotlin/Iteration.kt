import java.util.*

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun main(args: Array<String>) {
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    println()

    //100 downTo 1 -> 역방향
    //step -> skip
    for (i in 100 downTo 1 step 2) {
        print(fizzBuzz(i))
    }

    println()

    // 100 미만
    for(i in 0 until 100) {
        print(fizzBuzz(i))
    }

    println()

    val binaryReps = TreeMap<Char, String>()
    for(c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        //java의 map.put(c, binary)와 같다!
        binaryReps[c] = binary
    }

    for((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    val list = arrayListOf("10", "11", "1001")
    for((index, element) in list.withIndex()) {
        println("$index : $element")
    }

    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8'))
    println("Kotlin" in setOf("Java", "Scala"))
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a Digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know!"
}