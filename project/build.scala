import sbt._
import Keys._
import sbtassembly.Plugin._
import net.virtualvoid.sbt.graph.Plugin._
import AssemblyKeys._

object Builds extends Build {
  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    version := "1.0.0-SNAPSHOT",
    organization := "me.imen",
    scalaVersion := "2.10.3"
  )

  lazy val app = Project("app", file("app"),
    settings = buildSettings ++ assemblySettings ++ graphSettings) settings(
      // your settings here
    )
}
