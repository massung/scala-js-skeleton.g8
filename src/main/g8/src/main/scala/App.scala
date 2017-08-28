import scala.scalajs.js

import js.JSApp
import js.annotation.JSExportTopLevel

import org.scalajs.dom
import dom.document

object $name;format="Camel"$ extends JSApp {
    var count: Int = 0

    // Called on load because scalaJSUseMainModuleInitializer is set
    // to true in the build.sbt file.
    def main(args: Array[String]): Unit = ()

    // Expose this method to other JS routines and HTML.
    @JSExportTopLevel("addMsg")
    def addMsg(): Unit = {
        count += 1

        val div = document.createElement("div")
        val text = document.createTextNode(s"Clicked \$count times.")

        div.appendChild(text)
        document.body.appendChild(div)
    }
}
