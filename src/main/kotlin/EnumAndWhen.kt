enum class Color { //소프트 키워드 ?
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

enum class Color2(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color2) =
    when (color) {
        Color2.RED -> "Richard"
        Color2.ORANGE -> "Of"
        Color2.YELLOW -> "York"
        Color2.GREEN -> "Gave"
        Color2.BLUE -> "Battle"
        Color2.INDIGO -> "In"
        Color2.VIOLET -> "Vain"
    }
//when 분기 안에 여러값 사용 가능
fun getWarmth(color: Color2) =
    when (color) {
        Color2.RED, Color2.ORANGE, Color2.YELLOW -> "warm"
        Color2.GREEN -> "neutral"
        Color2.BLUE ,Color2.INDIGO, Color2.VIOLET -> "cold"
    }
// when  분기 조건 안에 여러 다른 객체 사용 가능
fun mix(c1: Color2, c2: Color2) =
    when (setOf(c1, c2)) {
        setOf(Color2.RED, Color2.YELLOW) -> Color2.ORANGE
        setOf(Color2.YELLOW, Color2.BLUE) -> Color2.GREEN
        setOf(Color2.BLUE, Color2.VIOLET) -> Color2.INDIGO
        else -> throw Exception("Dirty color")
    }
//인자가 없는 when

fun mixOptimize(c1: Color2, c2: Color2) =
    when {
        (c1 == Color2.RED && c2 == Color2.YELLOW) ||
                (c1 == Color2.YELLOW && c2 == Color2.RED) ->
            Color2.ORANGE
        (c1 == Color2.YELLOW && c2 == Color2.BLUE) ||
                (c1 == Color2.BLUE && c2 == Color2.YELLOW) ->
            Color2.GREEN
        (c1 == Color2.BLUE && c2 == Color2.VIOLET) ||
                (c1 == Color2.VIOLET && c2 == Color2.BLUE) ->
            Color2.INDIGO

        else -> throw Exception("Dirty color")
    }

fun main(args: Array<String>) {
    println(Color2.BLUE.rgb())
    println(getMnemonic(Color2.BLUE))
    println(getWarmth(Color2.BLUE))
    println(mix(Color2.BLUE, Color2.YELLOW))
    println(mixOptimize(Color2.BLUE, Color2.YELLOW))
}