package choe.scalabanav2.domain

case class AppSettings(
    scalabana: ScalabanaSettings
)
case class ScalabanaSettings(
    file: FileSettings,
    http: Option[HttpSettings],
    filter: Option[String],
    patterns: Option[List[Pattern]],
    database: Option[DatabaseSetting]
)
case class HttpSettings(port: Option[Int])
case class FileSettings(path: List[String])
case class Pattern(patternName: String, regex: String)
case class DatabaseSetting(elasticSearch: Option[ElasticSearchSetting])
case class ElasticSearchSetting(host: String, port: Int)
