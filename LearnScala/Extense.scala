extension (s: String)
    def hello: String = s"Hello, ${s.capitalize}!"
    def aloha: String = s"Aloha, ${s.capitalize}!"
    def makeInt(radix: Int): Int = Integer.parseInt(s, radix)

object Extense{
    def main(args: Array[String]) : Unit = {
        println("world".hello)
        println("friend".aloha)
        println("1".makeInt(2))
        println("FF".makeInt(16))
        println("765".makeInt(10))
    }
}