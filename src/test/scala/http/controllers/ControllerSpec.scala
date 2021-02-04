package http.controllers

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.server._
import Directives._
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers with ScalatestRouteTest {

  val testRoutes = (new Controller).routes

  "return expected value for GET Requests to the root path" in {
    Get() ~> testRoutes ~> check {
      responseAs[String] shouldEqual "<h1>Start Page of Akka!</h1>"
    }
  }

  "return expected value for GET Requests to the [/hello] path" in {
    Get("/hello") ~> testRoutes ~> check {
      responseAs[String] shouldEqual "<h2>Say hello to akka-http</h2>"
    }
  }
}