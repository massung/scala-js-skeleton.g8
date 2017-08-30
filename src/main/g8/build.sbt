enablePlugins(ScalaJSPlugin)

// project name/version
name := "$name;format="Camel"$"
version := "$version$"

// what version of scala to use
scalaVersion := "$scala_version$"

// add repositories to pull from
resolvers ++= Seq(
    // e.g. "jitpack" at "https://jitpack.io"
)

// libraries
libraryDependencies ++= Seq(
    // e.g. "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)

// javascript sources
jsDependencies ++= Seq(
    // e.g. "org.webjars.npm" % "phaser-ce" % "2.8.3"
)

// resources are in web directory
resourceDirectory := baseDirectory.value / "web"

// write files to to web/js
artifactPath in (Compile, fastOptJS) := resourceDirectory.value / "js" / s"${name.value}-fastopt.js"
artifactPath in (Compile, fullOptJS) := resourceDirectory.value / "js" / s"${name.value}-fullopt.js"
artifactPath in (Compile, packageJSDependencies) := resourceDirectory.value / "js" / s"${name.value}-jsdeps.js"

// put all js dependencies into a single output file
skip in packageJSDependencies := false

// call the `main` method after the js is loaded
scalaJSUseMainModuleInitializer := true

// do not emit source maps in production
emitSourceMaps in fullOptJS := false
