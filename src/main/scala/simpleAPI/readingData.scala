package simpleAPI

import io.circe.Json
import io.circe.syntax._

import scala.io.Source

object readingData {

  /** Load the file by name from the resources folder
    *
    * @param fileName
    * @return
    */
  def readData(fileName: String): List[Rows] = {
    val unParsed = Source.fromResource(fileName).getLines.toList.tail
    val numericalData = unParsed.map(x => x.split(",").map(_.toDouble))
    fileName match {
      case "rocks.csv" =>
        numericalData.map(x =>
          Rows.Rocks(area = x(0), peri = x(1), shape = x(2), perm = x(3)))
      case "cars.csv" =>
        numericalData.map(x => Rows.Cars(speed = x(0), distance = x(1)))
      case "pressure.csv" =>
        numericalData.map(x =>
          Rows.Pressure(temperature = x(0), pressure = x(1)))
    }
  }

  def getJson(fileName: String): Json = readData(fileName).asJson

}
