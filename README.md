# ScalaJS Skeleton App

This is a [Giter8][g8] skeleton for [ScalaJS][scalajs]. It is put together so that [ScalaJSBundler][bundler] works with a custom `webpack.config` file out-of-the-box and the application can be launched with [Electron][electron]. Launch configurations are pre-created for the [Visual Studio Code][vscode] editorg. But, use of it is not required.

## Getting Started

Download an install the following applications:

* [SBT][sbt]
* [NodeJS][nodejs]
* [Yarn][yarn] (optional)

Next, run [SBT][sbt] on the command line to initialize a new sekeleton.

```
$ sbt new massung/scala-js-skeleton.g8
```

Answer the questions that follow and your project should be ready to dive into. If you chose not to install [Yarn][yarn], then be sure and answer "no" when asked if [Yarn][yarn] should be used.

Once the skeleton has been cloned, `cd` into it and install all the [NodeJS][nodejs] dependencies with [Yarn][yarn] (or [npm][npm]).

```
$ yarn install
```

Next, launch [SBT][sbt] and build the source for the skeleton.

```
$ sbt
sbt:skelton> fastOptJS::webpack
[success] Total time: ...
```

At this point, you application's `-bundle.js` file has been built and resides in the `web/js` folder.

Finally, to run your app, there are a few options:

* Run via [Electron][electron]
* Serve via [Webpack Dev Server][server]

If using [VSCode][vscode], there are already 3 configurations pre-created for you: Run, Debug, and Serve. Otherwise, you can manually run/debug via the command line:

```
$ ./node_modules/.bin/electron main.js [debug]
```

Or you can start an [Express][express] web server via the command line:

```
$ node server.js [port=8080]
```

If you pass the `debug` command line argument to [Electron][electron] then the webkit debugger will be opened as well. From there, you should have access to your [Scala][scala] code, as a map file was generated for it.

## Structure

Here is a high-level breakdown of the skeleton source files:

* **project/** contains [SBT][sbt] plugins and settings
* **src/** contains all the [ScalaJS][scalajs] app code
* **web/** contains all the web server resources
* **main.js** is the [Electron][electron] application code
* **server.js** is the [Express][express] web server code

Everything in **web/** will be exposed to your application at runtime. And the [ScalaJS][scalajs] app will be compiled to JavaScript to **web/js/** folder.

## FAQ

*How can I change the name of my project and the compiled js file?*

There are two places:

* project/settings.scala
* package.json

*How do I change the window size of the app?*

Look at `main.js`. The `width` and `height` (along with other options) are specified there.

*Ensime isn't there, how do I get it?*

First, head to [the Ensime website][ensime] and see how to install it for all your [SBT][sbt] projects. Keep in mind that - as of this writing - [Ensime][ensime] doesn't yet work for [SBT][sbt] 1.0, on which this project is based.

[g8]:           http://www.foundweekends.org/giter8
[scala]:        http://www.scala.org
[scalajs]:      http://www.scala-js.org
[bundler]:      https://scalacenter.github.io/scalajs-bundler
[nodejs]:       https://nodejs.org
[electron]:     https://electron.atom.io
[webpack]:      https://webpack.js.org
[server]:       https://github.com/webpack/webpack-dev-server
[yarn]:         https://yarnpkg.com/en
[npm]:          https://www.npmjs.com
[zip]:          https://github.com/massung/scala-js-skeleton/archive/v1.0.zip
[sbt]:          http://www.scala-sbt.org
[vscode]:       https://code.visualstudio.com
[extension]:    https://marketplace.visualstudio.com/items?itemName=dragos.scala-lsp