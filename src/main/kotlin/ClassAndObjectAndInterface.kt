interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

class Button2: Clickable {
    override fun click() =
        println("I was cilcked!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button3: Clickable, Focusable {
    override fun click() = println("I was clicked!")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main (args: Array<String>) {
    Button2().click()
    Button2().showOff()
    Button3().showOff()
}