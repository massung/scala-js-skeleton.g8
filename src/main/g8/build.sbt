name := Settings.Name
version := Settings.Version

// what version of scala to use
scalaVersion := "$scala_version$"

// scala-js client project
lazy val app = project.in(file("."))
    .enablePlugins(ScalaJSPlugin)
    .settings(
        libraryDependencies ++= Seq(
            "org.scala-js" %%% "scalajs-dom" % "0.9.1"
        ),

        jsDependencies ++= Seq(
            "org.webjars.npm" % "rxjs" % "5.4.3"
        ),

        // where jar resources will be pulled from
        resourceDirectory := baseDirectory.value / "web",

        // copy the js compiled to the server resource path
        artifactPath in (Compile, fastOptJS) := resourceDirectory.value / "js" / (Settings.Name + "-fastopt.js"),
        artifactPath in (Compile, fullOptJS) := resourceDirectory.value / "js" / (Settings.Name + "-fullopt.js"),
        artifactPath in (Compile, packageJSDependencies) := resourceDirectory.value / "js" / (Settings.Name + "-jsdeps.js"),

        // put all js dependencies into a single output file
        skip in packageJSDependencies := false,

        // call the `main` method after the js is loaded
        scalaJSUseMainModuleInitializer := true,

        // emit source maps in production
        emitSourceMaps in fullOptJS := true
    )
