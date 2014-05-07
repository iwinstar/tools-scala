name := "tools"             // 项目名称

organization := "me.imen"   // 组织名称

version := "1.0.0-SNAPSHOT" // 版本号

scalaVersion := "2.10.4"    // 使用的Scala版本号

// 添加源代码编译或者运行期间使用的依赖
libraryDependencies += "log4j" % "log4j" % "1.2.17"

net.virtualvoid.sbt.graph.Plugin.graphSettings
