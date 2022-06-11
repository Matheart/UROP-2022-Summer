@main def myApp = 
    val evenOrOdd = 7 match
        case 1 | 3 | 5 | 7 | 9 => println("odd")
        case 2 | 4 | 6 | 8 | 10 => println("even")
        case _ => println("some other number")