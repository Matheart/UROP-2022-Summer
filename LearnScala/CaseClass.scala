case class Person(
    name: String,
    vocation: String
)

object CaseClass{
    def main(args: Array[String]) : Unit = {
        val p = Person("Kenneth", "Singer")
        println(p)
        println(p.name)
        //p.name = "Joe"
        val p2 = p.copy(name = "John")
        println(p2)
    }
}