enablePlugins(ScalaJSPlugin)

// project name/version
name := "$name;format="Camel"$"
version := "$version$"

// what version of scala to use
scalaVersion := "$scala_version$"

// compiler flags
scalacOptions ++= Seq(
  "-P:scalajs:sjsDefinedByDefault",
  "-feature",
  "-Ypartial-unification",
  "-Ywarn-value-discard"
)

// add repositories to pull from
resolvers ++= Seq(
  "jitpack" at "https://jitpack.io"
)

// libraries
libraryDependencies ++= Seq(
  // e.g. "org.scala-js" %%% "scalajs-dom" % "0.9.2"
)

// javascript sources
jsDependencies ++= Seq(
  // e.g. "org.webjars" % "vue" % "2.4.2" / "vue.js" commonJSName "Vue"
)

// resources are in web directory
resourceDirectory := baseDirectory.value / "web"

// write files to to web/js
artifactPath in (Compile, fastOptJS) := resourceDirectory.value / "js" / s"\${name.value}-fastopt.js"
artifactPath in (Compile, fullOptJS) := resourceDirectory.value / "js" / s"\${name.value}-fullopt.js"
artifactPath in (Compile, packageJSDependencies) := resourceDirectory.value / "js" / s"\${name.value}-jsdeps.js"

// put all js dependencies into a single output file
skip in packageJSDependencies := false

// call the `main` method after the js is loaded
scalaJSUseMainModuleInitializer := true

// do not emit source maps in production
emitSourceMaps in fullOptJS := false
