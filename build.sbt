organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.6"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers += "Whisk Snapshots" at "http://whisklabs.github.io/mvn-repo/snapshots/"

libraryDependencies ++= {
  val akkaV = "2.3.9"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "com.typesafe.play"   %%  "play-json"     % "2.3.7",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test",
    "com.whisk"           %%  "reactiverogue-record-dsl" % "0.1.0-18c987b"
  )
}

Revolver.settings


fork in run := true
