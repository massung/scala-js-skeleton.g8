enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)

// project name/version
name := "$name;format="Camel"$"
version := "$version$"

// what version of scala to use
scalaVersion := "$scala_version$"

// compiler flags
scalacOptions ++= Seq(
  "-P:scalajs:sjsDefinedByDefault",
  "-feature"
)

// add repositories to pull from
resolvers ++= Seq(
  // e.g. "jitpack" at "https://jitpack.io"
)

// libraries
libraryDependencies ++= Seq(
  // e.g. "org.scala-js" %%% "scalajs-dom" % "0.9.1"
)

// nodejs sources
npmDependencies in Compile ++= Seq(
  // e.g. "snabbdom" -> "0.5.3"
)

// root webpack config file
webpackConfigFile := Some(baseDirectory.value / "webpack.config.js")

// optionally use yarn over npm
useYarn := $use_yarn$

// put all js dependencies into a single output file
skip in packageJSDependencies := false

// call the `main` method after the js is loaded
scalaJSUseMainModuleInitializer := true

// do not emit source maps in production
emitSourceMaps in fullOptJS := false
