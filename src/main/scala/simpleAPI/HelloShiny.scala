package simpleAPI

import io.circe.Json
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._

object HelloShiny {

  val service = HttpService {

    case GET -> Root / "data" / name => Ok(
      Json.obj("payload" -> simpleAPI.readingData.getJson(name))
    )
  }

}
