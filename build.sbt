name        := "gfc-aws-s3"

organization  := "com.gilt"

description := "Library to handle data streaming to and from s3"

scalaVersion  := "2.12.10"

crossScalaVersions := Seq(scalaVersion.value, "2.11.12", "2.13.1")

scalacOptions += "-target:jvm-1.8"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

libraryDependencies ++= Seq(
  "org.slf4j"          % "slf4j-api"        % "1.7.28",
  "com.amazonaws"      %  "aws-java-sdk-s3" % "1.11.631",
  "com.typesafe.akka"  %% "akka-stream"     % "2.5.25",
  "org.scalatest"     %% "scalatest"                   % "3.0.8" % Test,
  "org.scalamock"     %% "scalamock"        % "4.4.0" % Test
)


releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

startYear := Some(2017)

licenses := Seq("Apache-style" -> url("https://raw.githubusercontent.com/gilt/gfc-aws-s3/master/LICENSE"))

homepage := Some(url("https://github.com/gilt/gfc-aws-s3"))

pomExtra := (
  <scm>
    <url>https://github.com/gilt/gfc-aws-s3.git</url>
    <connection>scm:git:git@github.com:gilt/gfc-aws-s3.git</connection>
  </scm>
    <developers>
      <developer>
        <id>mikegirkin</id>
        <name>Mike Girkin</name>
        <url>https://github.com/mikegirkin</url>
      </developer>
    </developers>
  )
