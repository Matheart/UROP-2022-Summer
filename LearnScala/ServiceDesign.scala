trait SubjectObserver:

    type S <: Subject // S is subtype of Subject
    type O <: Observer

    trait Subject{ self: S => // self-type annotation
        private var observers: List[O] = List()
        def subscribe(obs: O): Unit = 
            observers = obs :: observers
        def publish() = 
            for obs <- observers do obs.notify(this)
    }

    trait Observer{
        def notify(sub: S): Unit
    }

// implementing the Component
object SensorReader extends SubjectObserver:
    type S = Sensor
    type O = Display

    class Sensor(val label: String) extends Subject:
        private var currentValue = 0.0
        def value = currentValue
        def changeValue(v: Double) = 
            currentValue = v
            publish()
    
    class Display extends Observer:
        def notify(sub: Sensor) = 
            println(s"${sub.label} has value ${sub.value}")

@main def myApp = 
    import SensorReader.*
    // setting up a network
    val s1 = Sensor("sensor1")
    var s2 = Sensor("sensor2")
    var d1 = Display()
    var d2 = Display()
    s1.subscribe(d1)
    s1.subscribe(d2)
    s2.subscribe(d1)
    // propagating updates through the network
    s1.changeValue(2)
    s2.changeValue(3)
    // prints: