name := """blog-akka"""

version := "0.1.0"

scalaVersion := "2.12.2"

val akkaHttpVersion = "10.0.6"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "3.0.1",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test")


libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.0.0"

libraryDependencies += "com.github.cb372" %% "scalacache-guava" % "0.9.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http",
  "com.typesafe.akka" %% "akka-http-spray-json"
).map(_ % akkaHttpVersion)


libraryDependencies ++= Seq(
  "com.pauldijou" %% "jwt-core" % "0.12.0"
)


libraryDependencies += "shine.st" %% "common" % "2.0.0"

resolvers += "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository"

enablePlugins(JavaAppPackaging)