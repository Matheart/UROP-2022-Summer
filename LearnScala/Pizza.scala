import scala.util.FromDigits.NumberTooLarge
enum CrustSize:
    case Small, Medium, Large

enum CrustType:
    case Thin, Thick, Regular

enum Topping:
    case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

import CrustSize.*
import CrustType.*
import Topping.*

case class Pizza(
    crustSize: CrustSize,
    crustType: CrustType,
    toppings: Seq[Topping]
)

trait PizzaServiceInterface:
    def price(p: Pizza): Double

    def addTopping(p: Pizza, t: Topping): Pizza
    def removeAllToppings(p: Pizza): Pizza

    def updateCrustSize(p: Pizza, cs: CrustSize): Pizza
    def updateCrustType(p: Pizza, ct: CrustType): Pizza

def toppingPrice(t: Topping): Double = t match
    case Cheese | Onions => 0.5
    case Pepperoni | BlackOlives | GreenOlives => 0.75    

def crustPrice(s: CrustSize, t: CrustType): Double = 
    (s, t) match
        case (Small | Medium, _) => 0.25
        case (Large, Thin) => 0.50
        case (Large, Regular) => 0.75
        case (Large, Thick) => 1.00

object PizzaService extends PizzaServiceInterface:
    def price(p: Pizza): Double = p match
        case Pizza(crustSize, crustType, toppings) =>
            val base = 6.00
            val crust = crustPrice(crustSize, crustType)
            val tops = toppings.map(toppingPrice).sum
            base + crust + tops    

    def addTopping(p: Pizza, t: Topping): Pizza = 
        p.copy(toppings = p.toppings :+ t) // append
    
    def removeAllToppings(p: Pizza): Pizza = 
        p.copy(toppings = Seq.empty)
    
    def updateCrustSize(p: Pizza, cs: CrustSize): Pizza = 
        p.copy(crustSize = cs)
    
    def updateCrustType(p: Pizza, ct: CrustType): Pizza =
        p.copy(crustType = ct)

end PizzaService

@main def PizzaApp =
    import PizzaService.*

    val p = Pizza(Small, Thin, Seq(Cheese))
    val p1 = addTopping(p, Pepperoni)
    val p2 = addTopping(p1, Onions)
    val p3 = updateCrustType(p2, Thick)
    val p4 = updateCrustSize(p3, Large)

    println(price(p4))