package simpleAPI

import io.circe._
import io.circe.literal._
import io.circe.syntax._

import scala.io.Source

object readingData extends App {

  case class Cars(speed: Double, distance: Double)
  case class Pressure(temperature: Double, pressure: Double)
  case class Rocks(area: Double, peri: Double, shape: Double, perm: Double)

  implicit val carsEncoder: Encoder[Cars] =
    Encoder.instance { data: Cars =>
      json"""{"distance": ${data.distance}, "speed": ${data.speed}}"""
    }

  implicit val pressureEncoder: Encoder[Pressure] =
    Encoder.instance { data: Pressure =>
      json"""{"temperature": ${data.temperature}, "pressure": ${data.pressure}}"""
    }

  implicit val rocksEncoder: Encoder[Rocks] =
    Encoder.instance { data: Rocks =>
      json"""{"area": ${data.area}, "peri": ${data.peri}, "perm": ${data.perm}, "shape": ${data.shape}}"""
    }

  /** Read the data from the resources, parse and then export as a List of Row Data
    *
    * @return
    */
  def getRocks: List[Json] = {
    val unParsed = Source.fromResource("rocks.csv").getLines.toList.tail
    val numericalData = unParsed.map(x => x.split(",").map(_.toDouble))
    val output: List[Rocks] = numericalData.map(
      x => Rocks(area = x(0), peri = x(1), shape = x(2), perm = x(3)))
    output.map(_.asJson)
  }

  /** Read the data from the resources, parse and then export as a List of Row Data
    *
    * @return
    */
  def getCars: List[Json] = {
    val unParsed = Source.fromResource("cars.csv").getLines.toList.tail
    val numericalData = unParsed.map(x => x.split(",").map(_.toDouble))
    val output = numericalData.map(
      x => Cars(speed = x(0), distance = x(1)))
    output.map(_.asJson)
  }

  /** Read the data from the resources, parse and then export as a List of Row Data
    *
    * @return
    */
  def getPressure: List[Json] = {
    val unParsed = Source.fromResource("pressure.csv").getLines.toList.tail
    val numericalData = unParsed.map(x => x.split(",").map(_.toDouble))
    val output = numericalData.map(
      x => Pressure(temperature = x(0), pressure = x(1)))
    output.map(_.asJson)
  }

}
