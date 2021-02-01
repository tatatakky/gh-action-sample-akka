name := "gh-action-sample-akka"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"   % "10.2.3",
  "com.typesafe.akka" %% "akka-stream" % "2.6.12"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature"
)