package simpleAPI

import java.util.concurrent.{ExecutorService, Executors}

import io.circe.Json
import io.circe.generic.auto._
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl._
import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server.{Server, ServerApp}
import simpleAPI.Rows.{Hello, data}
import simpleAPI.readingData.getJson

import scala.util.Properties.envOrNone
import scalaz.concurrent.Task

object ShinyScala extends ServerApp {

  val port: Int = envOrNone("HTTP_PORT") map (_.toInt) getOrElse 8080
  val ip = "0.0.0.0"
  val pool: ExecutorService = Executors.newCachedThreadPool()

  override def server(args: List[String]): Task[Server] =
    BlazeBuilder
      .bindHttp(port, ip)
      .mountService(service)
      .withServiceExecutor(pool)
      .start

  lazy val rockData: Json = getJson("rocks.csv")
  lazy val carData: Json = getJson("cars.csv")
  lazy val pressureData: Json = getJson("pressure.csv")

  val service = HttpService {
    case GET -> Root / "data" / name =>
      name match {
        case "rocks" => Ok(Json.obj("payload" -> rockData))
        case "cars" => Ok(Json.obj("payload" -> carData))
        case "pressure" => Ok(Json.obj("payload" -> pressureData))
        case _ => NoContent()
      }
    case req @ POST -> Root / "message" =>
      for {
        user <- req.as(jsonOf[data])
        resp <- Ok(Json.obj("Message" -> Json.fromString(
          s"Hello ${Hello(user.data.name).greeting} this is your http4s API")))
      } yield resp
  }
}
