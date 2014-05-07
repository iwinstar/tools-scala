import sbt._
import Keys._
import sbtassembly.Plugin._
import AssemblyKeys._

object Builds extends Build {
  lazy val buildSettings = Defaults.defaultSettings ++ Seq(
    version := "1.0.0-SNAPSHOT",
    organization := "me.imen",
    scalaVersion := "2.10.4"
  )

  lazy val app = Project("tools-scala", file("."),
    settings = buildSettings ++ assemblySettings).settings(
      net.virtualvoid.sbt.graph.Plugin.graphSettings: _*
    ) settings (
      // your settings here
    )
}