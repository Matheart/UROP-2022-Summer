object MatchType{
    def getClassAsString(x: Matchable): String = x match
        case s: String => s"${s} is a String"
        case i: Int => "Int"
        case d: Double => "Double"
        case l: List[_] => "List"
        case _ => "Unknown"
    
    def main(args: Array[String]) : Unit = {
        println( getClassAsString(1) )
        println( getClassAsString("hello"))
        println( getClassAsString(List(1, 2, 3)))
    }
}