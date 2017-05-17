package simpleAPI

import io.circe.{Encoder}
import io.circe.generic.auto._
import io.circe.syntax._

sealed trait Rows

object Rows {

  case class Cars(speed: Double, distance: Double) extends Rows

  case class Pressure(temperature: Double, pressure: Double) extends Rows

  case class Rocks(area: Double, peri: Double, shape: Double, perm: Double)
      extends Rows

  implicit val encodeEvent: Encoder[Rows] = Encoder.instance {
    case e @ Cars(x, y) => e.asJson
    case e @ Pressure(x, y) => e.asJson
    case e @ Rocks(x, y, z, a) => e.asJson
  }
}
