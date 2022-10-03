data class Person5(val name: String, val age: Int)
data class Book(val title: String, val authors: List<String>)

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })

    val people = listOf(Person5("Alice", 29), Person5("Bob", 31))
    println(people.filter { it.age > 30 })

    println(list.map { it * it })

    println(people.map { it.name })
    println(people.map { Person5::name })
    println(people.filter { it.age > 30 }.map { it.name })

    val maxAge = people.maxBy(Person5::age)!!.age
    people.filter { it.age === maxAge }

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toString().toUpperCase() })

    val canBeInClub27 = { p: Person5 -> p.age <= 27 }
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))

    val people2 = listOf(Person5("Alice", 29), Person5("Bob", 31), Person5("Carol", 31))
    println(people2.groupBy { it.age })

    val list2 = listOf("a", "ab", "b")
    println(list2.groupBy(String::first))

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(
        Book("Thrusday Nest", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
    )

    println(books.flatMap { it.authors }.toSet())

    println(people2.asSequence()
        .map(Person5::name)
        .filter { it.startsWith("A") }
        .toList())

}
