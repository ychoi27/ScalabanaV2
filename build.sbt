name := "scalabanav2"

version := "0.1"

//scalaVersion := "2.13.0"

lazy val akkaHttpVersion = "10.1.9"
lazy val akkaVersion    = "2.5.25"
val CirceConfigVersion = "0.6.1"

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization    := "com.example",
      scalaVersion    := "2.12.8"
    )),
    name := "scalabanav2",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http"            % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-xml"        % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-stream"          % akkaVersion,
      "io.circe"       %% "circe-config"            % CirceConfigVersion,

      "com.typesafe.akka" %% "akka-http-testkit"    % akkaHttpVersion % Test,
      "com.typesafe.akka" %% "akka-testkit"         % akkaVersion     % Test,
      "com.typesafe.akka" %% "akka-stream-testkit"  % akkaVersion     % Test,
      "org.scalatest"     %% "scalatest"            % "3.0.8"         % Test
    )
  )


//
//val Http4sVersion      = "0.20.1"
//val CirceVersion       = "0.11.1"
//val Specs2Version      = "4.1.0"
//val LogbackVersion     = "1.2.3"
//val TypesafeVersion    = "1.2.1"
//val ZioVersion         = "1.0-RC5"

//val elastic4sVersion   = "6.3.7"
//
//lazy val root = (project in file("."))
//  .settings(
//    organization := "choeDynasty",
//    name := "scalabana",
//    version := "0.0.1-SNAPSHOT",
//    scalaVersion := "2.12.8",
//    scalacOptions ++= Seq("-Ypartial-unification"),
//    libraryDependencies ++= Seq(
//      "org.http4s"     %% "http4s-blaze-server"     % Http4sVersion,
//      "org.http4s"     %% "http4s-blaze-client"     % Http4sVersion,
//      "org.http4s"     %% "http4s-circe"            % Http4sVersion,
//      "org.http4s"     %% "http4s-dsl"              % Http4sVersion,
//      "io.circe"       %% "circe-generic"           % CirceVersion,
//      "io.circe"       %% "circe-parser"            % CirceVersion,
//      "org.scalamock"  %% "scalamock"               % "4.1.0" % "test",
//      "org.scalatest"  %% "scalatest"               % "3.0.5" % "test",
//      "ch.qos.logback" % "logback-classic"          % LogbackVersion,

//      "org.scalaz"     %% "scalaz-zio"              % ZioVersion,
//      "org.scalaz"     %% "scalaz-zio-interop-cats" % ZioVersion,
//      "jp.ne.opt"      %% "chronoscala"             % "0.3.1"
//    ),
//    addCompilerPlugin("org.spire-math" %% "kind-projector"     % "0.9.6"),
//    addCompilerPlugin("com.olegpy"     %% "better-monadic-for" % "0.2.4")
//  )
//
//libraryDependencies ++= Seq(
//  "com.sksamuel.elastic4s"   %% "elastic4s-core"     % elastic4sVersion,
//  "com.sksamuel.elastic4s"   %% "elastic4s-http"     % elastic4sVersion,
//  "com.sksamuel.elastic4s"   %% "elastic4s-embedded" % elastic4sVersion,
//  "org.slf4j"                % "slf4j-simple"        % "1.7.25",
//  "org.apache.logging.log4j" % "log4j-core"          % "2.11.1",
//  "com.sksamuel.elastic4s"   %% "elastic4s-testkit"  % elastic4sVersion % Test
//)
//
//scalacOptions ++= Seq(
//  "-deprecation",
//  "-encoding",
//  "UTF-8",
//  "-language:higherKinds",
//  "-language:postfixOps",
//  "-feature",
//  "-Ypartial-unification",
//  "-Xfatal-warnings"
//)
//
//coverageEnabled := true