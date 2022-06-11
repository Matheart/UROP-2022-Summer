trait Speaker:
    def speak(): String

trait TailWagger:
    def startTail(): Unit = println("tail is wagging")
    def stopTail(): Unit = println("tail is stopped")

trait Runner:
    def startRunning(): Unit = println("I'm running")
    def stopRunning(): Unit = println("Stopped running")

class Dog(name: String) extends Speaker, TailWagger, Runner:
    def speak(): String = "Woof!"

class Cat(name: String) extends Speaker, TailWagger, Runner:
    def speak(): String = "Meow"
    override def startRunning(): Unit = println("Yeah ... I don't run")
    override def stopRunning(): Unit = println("No need to stop")

// firstName, and lastName are mutable
class Person(var firstName: String, var lastName: String):
    def printFullName() = println(s"$firstName $lastName")

object LearnTrait{
    def main(args: Array[String]) : Unit = {
        /*
        val d = Dog("Rover")
        println(d.speak())

        val c = Cat("Morris")
        println(c.speak())
        c.startRunning()
        c.stopRunning()
        */
        val p = Person("John", "Stephens")
        println(p.firstName)
        p.lastName = "Legend"
        p.printFullName()
    }
}