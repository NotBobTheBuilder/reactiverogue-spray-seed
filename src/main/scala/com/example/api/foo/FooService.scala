package com.example.api.foo

import reactivemongo.bson.BSONObjectID
import reactivemongo.core.commands.GetLastError

import scala.concurrent.{ExecutionContext, Future}
import reactiverogue.core.LiftRogue

import scala.concurrent.ExecutionContext.Implicits.global


object FooService extends LiftRogue {
  def getFoos: Future[Seq[Foo]] = {
    FooRecord.fetch(10).map(_.toSeq.map(_.toWireFormat))
  }

  def getFoo(id: String): Future[Option[Foo]] = {
    FooRecord.where(_.id eqs BSONObjectID(id)).get().map(_.map(_.toWireFormat))
  }

  def createFoo(f: Foo): Future[Foo] = {
    val r = FooRecord.createRecord
            .name(f.name)

    r.save(GetLastError(j = true)).map(_ => r.toWireFormat)
  }

  def updateFoo(id: String, newFoo: Foo): Future[Option[Foo]] = {
    FooRecord.where(_.id eqs BSONObjectID(id)).get() flatMap {
      case Some(r) =>
        val foo = r.fromWireFormat(newFoo)
        foo.save(GetLastError(j = true)).map(_ => Some(foo.toWireFormat))
      case None =>
        Future.successful(None)
    }
  }

}
