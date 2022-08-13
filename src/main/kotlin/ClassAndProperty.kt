//public class Person {
//    private final String name;
//
//    public Person(String name){
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}

//자바에서 위와 같이 쓰던 클래스, 프로퍼티(필드와 접근자)가 코틀린에서는 아래 처럼 간결해졌다!
class Person2(val name: String, //getter 만 만듬
var isMarried : Boolean) //getter, setter 만듬


fun main(args: Array<String>) {
    val person = Person2("Bob", true) // new 키워드 사용 안하고 생성자 호출
    println(person.isMarried)
    person.isMarried = false //setter 호출
    println(person.isMarried)

    val rectangle = Rectangle(41, 43)
    print(rectangle.isSquare);


}
//커스텀 접근자
class Rectangle(val height: Int, val width: Int) {
//    val isSquare: Boolean
//    get() {
//        return height == width
//    }

    val isSquare: Boolean
    get() = height == width;
}



