name := Settings.Name
version := Settings.Version

// what version of scala to use
scalaVersion := "$scala_version$"

// add repositories to pull from
resolvers ++= Seq(
    // TODO:
)

lazy val app = project.in(file("."))
    .enablePlugins(ScalaJSPlugin)
    .settings(
        libraryDependencies ++= Seq(
            "org.scala-js" %%% "scalajs-dom" % "0.9.1"
        ),

        // webjar sources
        jsDependencies ++= Seq(
            // TODO:
        )

        // resources are in web directory
        resourceDirectory := baseDirectory.value / "web",

        // write files to to web/js
        artifactPath in (Compile, fastOptJS) := resourceDirectory.value / "js" / "app-fastopt.js",
        artifactPath in (Compile, fullOptJS) := resourceDirectory.value / "js" / "app-fullopt.js",
        artifactPath in (Compile, packageJSDependencies) := resourceDirectory.value / "js" / "app-jsdeps.js",

        // put all js dependencies into a single output file
        skip in packageJSDependencies := false,

        // call the `main` method after the js is loaded
        scalaJSUseMainModuleInitializer := true,

        // do not emit source maps in production
        emitSourceMaps in fullOptJS := false
    )
