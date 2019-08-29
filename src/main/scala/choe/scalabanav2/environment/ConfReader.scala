package choe.scalabanav2.environment

import cats.instances.future._
import choe.scalabanav2.domain.AppSettings
import io.circe.Json
import io.circe.config.parser
import io.circe.generic.auto._
import io.circe.syntax._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ConfReader {
  def confReader: ConfReader.Service
}

object ConfReader {
  trait Service {
    def get: Future[AppSettings]
    def getJson: Future[Json]
  }

  object LiveImpl extends ConfReader.Service {
    private lazy val settings = parser.decodeF[Future, AppSettings]

    override def get: Future[AppSettings] = settings

    override def getJson: Future[Json] = get.map(_.asJson)
  }
}
