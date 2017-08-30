# ScalaJS Skeleton App

This is a [Giter8][g8] skeleton for [ScalaJS][scalajs]. It can be launched with [Electron][electron] or served with [Express][express] out-of-the-box. And launch configurations are pre-created for the [Visual Studio Code][vscode] editor. But, use of it is not required.

## Getting Started

Download an install the following applications:

* [SBT][sbt]
* [NodeJS][nodejs]
* [Yarn][yarn] (optional)

Next, run [SBT][sbt] on the command line to initialize a new sekeleton.

```
$ sbt new massung/scala-js-skeleton.g8
```

Once the skeleton has been created, `cd` into it and install all the [NodeJS][nodejs] dependencies with [Yarn][yarn] (or [npm][npm]).

```
$ yarn install
```

Next, launch [SBT][sbt] and build the source for the skeleton.

```
sbt> fastOptJS
```

At this point, you application's compiled `.js` file has been built and resides in the `web/js` folder along with a `.map.js` file and any dependencies.

To run your app, there are a few options:

* Run via [Electron][electron]
* Serve via [Express][express]

If you are using [VSCode][vscode], there are already launch configurations created for each: Run/Debug ([Electron][electron]) and Serve ([Express][express]).

Otherwise, you can manually run/debug via the command line:

```
$ ./node_modules/.bin/electron main.js [debug]
```

If you pass the `debug` argument on the command line, then the webkit debugger will be opened as well. From there, you should have access to your [Scala][scala] code, as a map file was generated for it.

Or start the [Express][express] server:

```
$ node server.js [port=8080]
```

That's it!

## Structure

Here is a high-level breakdown of the skeleton source files:

* **project/** contains [SBT][sbt] plugins and settings
* **src/** contains all the [ScalaJS][scalajs] app code
* **web/** contains all the static resources, and your app bundle
* **main.js** is the [Electron][electron] application code
* **server.js** is the [Express][express] web server code

Everything in **web/** will be exposed to your application at runtime. And the [ScalaJS][scalajs] app will be compiled to JavaScript to **web/js/** folder.

[g8]:           http://www.foundweekends.org/giter8
[scala]:        http://www.scala.org
[scalajs]:      http://www.scala-js.org
[nodejs]:       https://nodejs.org
[electron]:     https://electron.atom.io
[express]:      http://expressjs.com
[yarn]:         https://yarnpkg.com/en
[npm]:          https://www.npmjs.com
[sbt]:          http://www.scala-sbt.org
[vscode]:       https://code.visualstudio.com
