fun main(args: Array<String>) {
    val set = hashSetOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to " fifty-three")

    //자바 클래스 사용
    println(set.javaClass)
    // 자바 보다 더 많은 기능 사용 가능, 자바 코드와 상호작용 하기 쉬움
    println(list.last())
    println(list.joinToString(";", "(", ")"))
    println(list.joinToString(separator = ";", prefix = "(", postfix = ")"))
    println(list.joinToString())
    println(list.joinToString(";"))


    println("Kotlin".lastChar())

    val view: View = Button()
    view.click()
    //확장함수는 정적으로 결정된다. 확장함수는 첫번째 인자가 수신객체인 정적 자바 메서드로 컴파일 한다.
    view.showOff()

    println("Kotlin".lastChar)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

    //가변인자 함수
    val list2 = listOf("args :", *args)
    println(list2)

//    val (number, name) = 1 to "one"
//
//    println(number, name)

    println("12.345-6.A".split(".","-"))

    parsePath("Users/yole/kotlin-book/chapter.adoc")

    val kotlinLogo = """| // 
        .| //
         .|/ \""".trimMargin()
    println(kotlinLogo.trimMargin("."))
//    saveUser(User(1,"", ""))

}

//fun <T> joinToString(
//    collection: Collection<T>,
//    separator: String = ",",
//    prefix : String = "",
//    postfix : String = "") : String {
//    val result = StringBuilder(prefix)
//
//    for((index, element) in collection.withIndex()) {
//        if(index > 0) result.append(separator)
//        result.append(element)
//    }
//
//    result.append(postfix)
//    return result.toString()
//}

//fun String.lastChar() : Char = this.get(this.length -1)
fun String.lastChar(): Char = get(length - 1)


fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

//확장함수는 오버라이드 할수 없다.
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")


//확장 프로퍼티
val String.lastChar: Char get() = get(length - 1)

//변경 가능한 확장 프로퍼티
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

//중위 호출 구조분해 선언
infix fun Any.to(other : Any) = Pair(this, other)

//fun parsePath(path: String) {
//    val directory = path.substringBeforeLast("/")
//    val fullName = path.substringAfterLast("/")
//    val filename = fullName.substringBeforeLast(".")
//    val extension = fullName.substringAfterLast(".")
//
//    println("Dir: $directory, name: filename, ext:$extension")
//}

fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext:$extension")
    }
}

//class User(val id: Int, val name: String, val address: String)

//fun saveUser(user: User) {
//    if(user.name.isEmpty()) {
//        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
//    }
//    if(user.address.isEmpty()) {
//        throw IllegalArgumentException("Can't save user ${user.id} : empty Address")
//    }
//}
//class User(val id: Int, val name: String, val address: String)
//중첩 함수
//fun saveUser(user: User) {
//    fun validate(value: String, fieldName: String) {
//        if(value.isEmpty()) {
//            throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
//        }
//        if(user.address.isEmpty()) {
//            throw IllegalArgumentException("Can't save user ${user.id} : empty Address")
//        }
//    }
//
//    validate(user.name, "Name")
//    validate(user.address, "Address")
//}
class User(val id: Int, val name: String, val address: String)
//중첩 함수
fun User.validateBeforeSave(user: User) {
    fun validate(value: String, fieldName: String) {
        if(value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
        }
        if(user.address.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id} : empty Address")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")
}

fun saveUser(user: User){
    user.validateBeforeSave(user)
}




