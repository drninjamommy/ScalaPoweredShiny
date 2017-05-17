package simpleAPI

import io.circe.Json
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._

object HelloShiny {

  val service = HttpService {

    case GET -> Root / "hammer" / name => Ok(
        Json.obj(
          "Message" -> Json.fromString(s"Hello ${name}, Python Added this!")))

    case GET -> Root / "rock" =>
      Ok(Json.obj("payload" -> Json.fromString(s"TODO -> rock table")))

    case GET -> Root / "car" =>
      Ok(Json.obj("payload" -> Json.fromString(s"TODO -> car table")))

    case GET -> Root / "pressure" =>
      Ok(Json.obj("payload" -> Json.fromString(s"TODO -> pressure table")))
  }

}
