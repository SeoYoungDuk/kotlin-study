fun main(args: Array<String>) {
    val immutableValue : Int = 42; // final
    var mutableVariable : Int = 42;
    //왠만하면 val 을 쓰고 꼭 필요할 때만 var 을 쓰자.

    val languages = arrayListOf("Java") // 불변 참조 선언
    languages.add("Kotlin") // 참조 객체 내부는 변경 가능

    var answer = 42;
//    answer = "no answer"// var로 선언 되어 있어도 타입이 다르면 재 할당 불가능!

    val name = if(args.size > 0) args[0] else "Kotlin"
    println("Hello $name!")
}