organization := "MeridianSolutions"
name := "danDixey"
version := "0.0.1-SNAPSHOT"
scalaVersion := "2.12.2"

val Http4sVersion = "0.15.11a"

libraryDependencies ++= Seq(
 "org.http4s"     %% "http4s-blaze-server" % Http4sVersion,
 "org.http4s"     %% "http4s-circe"        % Http4sVersion,
 "org.http4s"     %% "http4s-dsl"          % Http4sVersion,
 "ch.qos.logback" %  "logback-classic"     % "1.2.1",
 // Optional for auto-derivation of JSON codecs
 "io.circe" %% "circe-generic" % "0.6.1",
 // Optional for string interpolation to JSON model
 "io.circe" %% "circe-literal" % "0.6.1"
)
