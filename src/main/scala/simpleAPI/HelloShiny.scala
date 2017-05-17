package simpleAPI

import io.circe.Json
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._

object HelloShiny {

  var counter = 0
  val service = HttpService {
    case GET -> Root / "data" / name => {
      counter += 1
      println(counter)
      Ok(Json.obj("payload" -> simpleAPI.readingData.getJson(name)))
    }
  }
}
