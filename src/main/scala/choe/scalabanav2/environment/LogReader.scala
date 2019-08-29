package choeDynasty.scalabana.environment

import choeDynasty.scalabana.domain.Log
import scalaz.zio._

trait LogReader {
  def logReader: LogReader.Service
}

object LogReader {
  type LogReaderDependencies = FileReader
    with ConfReader
    with CurrentDate
    with Filtering

  trait Service {
    def getLog: TaskR[LogReaderDependencies, Seq[Log]]
    def getRawLog: TaskR[LogReaderDependencies, String]
  }

  object LiveImpl extends LogReader.Service {
    override def getLog: TaskR[LogReaderDependencies, Seq[Log]] =
      ZIO.accessM[LogReaderDependencies] { env =>
        for {
          settings <- env.confReader.get
          fileLines <- env.fileReader
            .getStringFromFiles(settings.scalabana.file.path)
          filteredLog <- env.filtering
            .filterLog(
              fileLines.split("\n"),
              settings.scalabana.filter,
              settings.scalabana.patterns.getOrElse(List.empty)
            )
            .provide(env)
        } yield filteredLog
      }

    override def getRawLog: TaskR[LogReaderDependencies, String] =
      ZIO.accessM[LogReaderDependencies] { env =>
        for {
          settings <- env.confReader.get
          fileLines <- env.fileReader.getStringFromFiles(
            settings.scalabana.file.path
          )
        } yield fileLines
      }
  }
}
