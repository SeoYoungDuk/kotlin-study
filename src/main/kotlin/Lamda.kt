data class Person4(val name: String, val age: Int)

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }

    println("$clientErrors client errors $serverErrors server errors")
}

fun main(args: Array<String>) {
    val people = listOf(Person4("Alice", 29), Person4("Bob", 31))
//    println(people.maxBy{ it.age})
    println(people.maxBy(Person4::age))
//    val names = people.joinToString(separator = " ", transform = {p: Person4 -> p.name})
    val names = people.joinToString(" ") { p: Person4 -> p.name }
    println(names)

    var errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Errors:")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)

    val createPerson = ::Person4
    val p = createPerson("Alice" , 29)
    println(p)
}