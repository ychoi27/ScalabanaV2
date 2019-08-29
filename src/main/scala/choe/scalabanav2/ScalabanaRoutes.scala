package choe.scalabanav2

import akka.http.scaladsl.model.HttpMethods.GET
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpRequest, HttpResponse, Uri}
import akka.stream.ActorMaterializer
import choe.scalabanav2.Main.system

object ScalabanaRoutes {
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  def requestHandler: HttpRequest => HttpResponse = {
    case HttpRequest(GET, Uri.Path("/scalabana"), _, _, _) =>
      HttpResponse(entity = HttpEntity(
        ContentTypes.`text/html(UTF-8)`,
        "<html><body>Hello world!</body></html>"))

    case HttpRequest(GET, Uri.Path("/scalabana/json"), _, _, _) =>
      HttpResponse(entity = "PONG!")

    case HttpRequest(GET, Uri.Path("/scalabana/search"), _, _, _) =>
      sys.error("search!")

    case HttpRequest(GET, Uri.Path("/scalabana/insert"), _, _, _) =>
      sys.error("insert!")

    case HttpRequest(GET, Uri.Path("/scalabana/delete"), _, _, _) =>
      sys.error("delete!")

    case r: HttpRequest =>
      r.discardEntityBytes() // important to drain incoming HTTP Entity stream
      HttpResponse(404, entity = "Unknown resource!")
  }

}
