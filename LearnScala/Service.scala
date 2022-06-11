trait AddService:
    def add(a: Int, b: Int) = a + b

trait MultiplyService:
    def multiply(a: Int, b: Int) = a * b

object MathService extends AddService, MultiplyService

object Service{
    def main(args: Array[String]) : Unit = {
        import MathService.*
        println(add(1, 1))
        println(multiply(2, 2))
    }
}