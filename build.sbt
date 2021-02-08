name := "gh-action-sample-akka"

version := "0.1"

scalaVersion := "2.13.4"

val akkaVersion ="2.6.12"
val akkaHttpVersion = "10.2.3"
val scalatestVersion = "3.2.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"           % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream"         % akkaVersion,

  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion,
  "com.typesafe.akka" %% "akka-http-testkit"   % akkaHttpVersion,
  "org.scalatest"     %% "scalatest"           % scalatestVersion
)

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-feature",
  "-unchecked"
)

assemblyJarName in assembly := "main.jar"