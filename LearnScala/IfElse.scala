object IfElse{
    def main(args: Array[String]): Unit = {
        val x = 3
        if x < 0 then
            println("negative")
        else if x == 0 then
            println("zero")
        else
            println("positive")
    }
}