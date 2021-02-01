import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {

    implicit val system           = ActorSystem("my-system")
    implicit val executionContext = system.dispatcher

    val routes =
      path("") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Start Page of Akka!</h1>"))
        }
      } ~ path("hello") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h2>Say hello to akka-http</h2>"))
        }
      }

    val bindingFuture = Http().newServerAt("0.0.0.0", 8080).bindFlow(routes)

    println(s"Server online at http://localhost:8080/")
    //StdIn.readLine() // let it run until user presses return
    //bindingFuture
    //  .flatMap(_.unbind()) // trigger unbinding from the port
    //  .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
