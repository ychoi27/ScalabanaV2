package choe.scalabanav2.domain

import io.circe._
import io.circe.syntax._

import scala.collection.immutable.ListMap

final case class Meta(
    timeStamp: String, // timestamp when log line was processed
    message: String    // original log line
)

object Meta {
  implicit val metaEncoder: Encoder[Meta] = (a: Meta) =>
    Json.obj(
      ("timestamp", Json.fromString(a.timeStamp)),
      ("message", Json.fromString(a.message))
    )
}

final case class Log(
    meta: Meta,
    field: ListMap[String, String] // filtered message
)

object Log {

  implicit val logEncoder: Encoder[Log] = (log: Log) => {
    val fieldJson =
      log.field.map(s => (s._1, Json.fromString(s._2))).toArray

    Json
      .obj(fieldJson: _*)
      .deepMerge(
        Json
          .obj(("meta", log.meta.asJson))
      )
  }
}
