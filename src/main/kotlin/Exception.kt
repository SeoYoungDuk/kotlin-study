import java.io.BufferedReader
import java.io.StringReader

fun main(args: Array<String>) {
//    val percentage = 10;
//    if(percentage !in 0..100) {
//        throw IllegalArgumentException("A percentage value must be be between 0 and 100: $percentage")
//    }

//    val number = -1;
//    val percentage =
//        if(number in 0..100) number
//    else
//        throw IllegalArgumentException("A percentage value must be be between 0 and 100: $number")

    val reader = BufferedReader(StringReader("not a number"))
    println(readNumber(reader))
}

//fun readNumber(reader: BufferedReader): Int? {
//    try {
//        val line = reader.readLine()
//        return Integer.parseInt(line)
//    }
//    catch (e: NumberFormatException) {
//        return null
//    }
//    finally {
//        reader.close()
//    }
//}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    }
    catch (e: NumberFormatException) {
        null
    }

    println(number)
}


