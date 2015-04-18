package com.example.api.foo

import play.api.libs.json.Json

import scala.reflect.ClassTag

case class Foo (id: Option[String], name: String, quality: Int)

object Foo {
  implicit val fmt = Json.format[Foo]
}
