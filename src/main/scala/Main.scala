import akka.actor.ActorSystem
import akka.http.scaladsl.Http

import http.controllers.Controller

import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {

    implicit val system           = ActorSystem("my-system")
    implicit val executionContext = system.dispatcher

    val routes = (new Controller).routes

    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bindFlow(routes)

    println(s"Server online at http://localhost:8080/")
    //StdIn.readLine() // let it run until user presses return
    //bindingFuture
    //  .flatMap(_.unbind()) // trigger unbinding from the port
    //  .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
