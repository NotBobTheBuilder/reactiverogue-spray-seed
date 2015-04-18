package com.example.api.foo

import com.foursquare.index.IndexedRecord
import reactiverogue.record.{ MongoRecord, MongoMetaRecord }
import reactiverogue.record.field.{ StringField, IntField }

class FooRecord extends MongoRecord[FooRecord] with IndexedRecord[FooRecord] {
  override def meta = FooRecord
  object name extends StringField(this)
  object quality extends IntField(this)

  def toWireFormat: Foo = {
    Foo(
      Some(this.id.toString),
      this.name.value,
      this.quality.value
    )
  }
  def fromWireFormat(f: Foo): FooRecord = {
    this
      .name(f.name)
      .quality(f.quality)
  }
}

object FooRecord extends FooRecord with MongoMetaRecord[FooRecord] {
  override def collectionName = "foos"
}
