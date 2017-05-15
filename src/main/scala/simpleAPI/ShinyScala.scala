package simpleAPI

import java.util.concurrent.{ExecutorService, Executors}

import org.http4s.server.blaze.BlazeBuilder
import org.http4s.server.{Server, ServerApp}

import scala.util.Properties.envOrNone
import scalaz.concurrent.Task

object ShinyScala extends ServerApp {

  val port: Int = envOrNone("HTTP_PORT") map (_.toInt) getOrElse 8080
  val ip: String = "0.0.0.0"
  val pool: ExecutorService = Executors.newCachedThreadPool()

  override def server(args: List[String]): Task[Server] =
    BlazeBuilder
      .bindHttp(port, ip)
      .mountService(HelloShiny.service)
      .withServiceExecutor(pool)
      .start

}
