package org.scalatra
package test
package specs2

abstract class MutableSalatraSpecSpec extends MutableScalatraSpec {

  mount(new ScalatraApp {
    protected var doNotFound: _root_.org.scalatra.Action = () => NotFound()
    get("/") { "Hello, world." }
  })


  "get" should {
    "be able to verify the response body" in {
      get("/") {
        body must_== "Hello, world."
      }
    }
  }
}

class NettyMutableSalatraSpecSpec extends MutableSalatraSpecSpec with NettyBackend