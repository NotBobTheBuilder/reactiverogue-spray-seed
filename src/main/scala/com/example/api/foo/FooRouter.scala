package com.example.api.foo

import spray.httpx.PlayJsonSupport
import spray.routing.Directives
import scala.concurrent.ExecutionContext.Implicits.global

object FooRouter extends Directives with PlayJsonSupport  {
  val route = pathPrefix("foo") {
    pathEndOrSingleSlash {
      get {
        complete(FooService.getFoos)
      } ~
      post {
        entity(as[Foo]) { foo: Foo =>
          complete(FooService.createFoo(foo))
        }
      }
    } ~ path(Segment) { id =>
      get {
        complete(FooService.getFoo(id))
      } ~ put {
        entity(as[Foo]) { foo: Foo =>
          complete(FooService.updateFoo(id, foo))
        }
      }
    }
  }
}
