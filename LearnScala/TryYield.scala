@main def myApp = 
    val names = List("_olivia", "_walter", "_peter")

    val capNames = for name <- names yield
        val nameWithoutUnderscore = name.drop(1)
        val capName = nameWithoutUnderscore.capitalize
        capName
        
    println(capNames)