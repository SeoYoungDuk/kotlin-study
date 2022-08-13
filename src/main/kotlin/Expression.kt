//함수를 클래스 안에 안 넣고, 함수 최상위 수준에 정의 가능
fun main(args: Array<String>) {
    println("Hello world;")
    println(max(1, 2))
}
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b //Kotlin은 if 문이 문(statement)이 아니고 식(expression)이다!
}

fun max2(a: Int, b: Int) = if (a > b) a else b //식이 본문인 함수는 return 생략이 가능하다!( 타입 추론 때문에 가능함)


