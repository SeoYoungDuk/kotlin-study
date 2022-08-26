import java.io.File
import java.io.Serializable
import javax.naming.Context
import javax.swing.text.AttributeSet

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

class Button2 : Clickable {
    override fun click() =
        println("I was cilcked!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button3 : Clickable, Focusable {
    override fun click() = println("I was clicked!")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

open class Button4 : Clickable {
    fun disable() {} //final 이어서 오버라이드 불가
    open fun animate() {} // 하위 클래스에서 오버라이드 해도된다.
    override fun click() = //오버라이드 한 메서드는 기본적으로 열려있다.
        println("I was cilcked!")
}

open class RichButton : Clickable {
    final override fun click() = //오버라이드 불가
        println("I was cilcked!")
}

abstract class Animated {
    abstract fun animate()//반드시 오버라이드
    open fun stopAnimating() {} // open 으로 오버라이드 허용 할수 있다.
    fun animateTwice() {}
}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech() { // public > internal 이라 안됨
//    yell() // private 이라 안됨
//    whisper() // protected라 안됨
//}

interface State : Serializable
interface View2 {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button6 : View2 {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState : State {}
}

sealed class Expr2 {
    class Num2(val value: Int) : Expr2()
    class Sum2(val left: Expr2, val right: Expr2) : Expr2()
}

fun eval2(e: Expr2): Int =
    when (e) {
        is Expr2.Num2 -> e.value
        is Expr2.Sum2 -> eval2(e.right) + eval2(e.left)
//        else ->
//            throw IllegalArgumentException("Unknown expression!") // when 식이 하위 클래스를 검사해서 else문 제거 가능!
    }

class User2(val nickName: String)

class User3 constructor(_nickname: String) {
    val nickName: String

    init {
        nickName = _nickname
    }
}

class User4(_nickname: String) {
    val nickName = _nickname
}

class User5(val nickName: String, val isSubScribed: Boolean = true)

open class User6(val nickname: String)
class TwitterUser(nickname: String) : User6(nickname) {

}

open class View3 {
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: AttributeSet) {
    }
}

class MyButton : View3 {
    constructor(ctx: Context) : super(ctx) {}
//    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr) {}
//    constructor(ctx : Context) : this(ctx, MY_STYLE) {}
}

interface User7 {
    val nickname: String
}

class PrivateUser(override val nickname: String) : User7
class SubscribingUser(val email: String) : User7 {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(private val accountId: Int) : User7 {
    override val nickname = getFacebookName(accountId)
}

fun getFacebookName(accountId: Int): String {
    return "!!!"
}

interface User8 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

// nickname은 오버라이드 안하고 상속 할 수 있음!
class TestUser(override val email: String) : User8

class User9(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name: "$field" -> "$value".""".trimIndent())
            field = value
        }
}

class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

class Client(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalcode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int =
        name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client(name, postalCode)
}
//data class Client(val name: String, val postalCode: Int)

class DelegatingCollection<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {}
class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class Person3(val name: String) {
    object NameComparator : Comparator<Person3> {
        override fun compare(o1: Person3, o2: Person3): Int =
            o1.name.compareTo(o2.name)
    }
}

class User10 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User10(email.substringBefore('@'))
        fun newFaceBookUser(accountId: Int) = User10(getFacebookName(accountId))
    }
}

//class Person4 (val name: String) {
//    companion object Loader {
//        fun fromJSON(jsonText: String) : Person4 = ...
//    }
//}


fun main(args: Array<String>) {
    Button2().click()
    Button2().showOff()
    Button3().showOff()

    val user5 = User5("현석")
    println(user5.isSubScribed)

    println(PrivateUser("test@kotilinlang.org").nickname)
    println(SubscribingUser("test@kotilinlang.org").nickname)

    val user = User9("Alice")
    user.address = "Elesenhemierstrasse 47, 80687 Muenchen"

    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)

    val client1 = Client("오현석", 4122)
    println(client1)

    val client2 = Client("오현석", 4122)
    println(client1 == client2)

    val processed = hashSetOf(Client("오현석", 4222))
    println(processed.contains(Client("오현석", 4222)))

    val lee = Client("이계명", 4122)
    println(lee.copy(postalCode = 4000))

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} ojects were added, ${cset.size} remain")

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/User")))

    var files = listOf(File("/z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(Person3("Bob"), Person3("Alice"))
    println(persons.sortedWith(Person3.NameComparator))

    val subscribingUser = User10.newSubscribingUser("bob@gmail.com")
    val facebookUser = User10.newFaceBookUser(4)
    println(subscribingUser.nickname)
}