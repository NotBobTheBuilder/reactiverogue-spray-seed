package com.example.api

import spray.can.Http.Bound
import spray.httpx.PlayJsonSupport
import spray.routing.{ RouteConcatenation, SimpleRoutingApp }

import scala.concurrent.Future

import com.example.core.Core
import com.example.api.foo.FooRouter

trait Api extends SimpleRoutingApp with RouteConcatenation with PlayJsonSupport { self: Core =>

  val routes = FooRouter.route

  def run(port: Int): Future[Bound] =
    startServer(interface = "0.0.0.0", port = port)(routes)
}
