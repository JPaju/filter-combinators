Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project
  .in(file("."))
  .settings(
    name         := "filter-combinators",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := "3.2.0",
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-explain",
      "-Xfatal-warnings",
      "-Ycheck-all-patmat",
      "-Ycheck-reentrant",
      "-Ykind-projector",
      "-Ysafe-init",
    ) ++ Seq("-source", "future"),
  )
