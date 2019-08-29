package choe.scalabanav2

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.model._
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.Sink
import choe.scalabanav2.environment.ConfReader

import scala.concurrent.Future

object Main extends App {

  implicit val system = ActorSystem("scalabana")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val defaultPort = 8080
  val confReader = ConfReader.LiveImpl


  val bindingFuture: Future[Http.ServerBinding] = {
    for {
      port <- confReader.get.map(c => c.scalabana.http.flatMap(_.port)).map(_.getOrElse(defaultPort))
      serverSource = Http().bind(interface = "0.0.0.0", port = port)
      server <- serverSource.to(Sink.foreach { connection =>
        println("Accepted new connection from " + connection.remoteAddress)

        connection handleWithSyncHandler ScalabanaRoutes.requestHandler
        // this is equivalent to
        // connection handleWith { Flow[HttpRequest] map requestHandler }
      }).run()
    } yield server
  }
}
