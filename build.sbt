name := """play-scala-intro"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"
// Don't allow libraryDependencies to upgrade Scala version
// (embrace wants 2.12.0-M3)
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }

//conflictWarning := ConflictWarning.disable

libraryDependencies ++= Seq(
  jdbc,
  "org.sorm-framework" % "sorm" % "0.3.19",
  cache,
  ws,
  specs2 % Test
)

dependencyOverrides ++= Set(
  "org.apache.httpcomponents" % "httpclient" % "4.3.4",
  "com.google.guava" % "guava" % "18.0",
  "org.apache.httpcomponents" % "httpcore" % "4.3.2",
  "commons-logging" % "commons-logging" % "1.1.3",
  "org.scala-lang.modules" % "scala-parser-combinators_2.11" % "1.0.4",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.4"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
