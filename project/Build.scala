import sbt._
import sbt.Keys._

object AppBuild extends Build {

  lazy val root = Project(
    id = "scalacop",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "scalacop",
      organization := "onmsr.scalacop",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.11.5",
      libraryDependencies ++= Seq(
        "org.scala-lang" % "scala-compiler" % "2.11.5",
        "org.specs2" %% "specs2-core" % "3.8.5" % "test",
        "org.mockito" % "mockito-core" % "2.2.28" % "test"
      ),
      scalacOptions in Test ++= Seq("-Yrangepos")
    )
  )
}
