package com.example.core

import akka.actor.ActorSystem
import com.typesafe.config.Config
import reactiverogue.mongodb.{ MongoAddress, DefaultMongoIdentifier, MongoDB }

trait Core {
  implicit lazy val system = ActorSystem("example")
  def config = system.settings.config

  MongoDB.defineDb(DefaultMongoIdentifier, MongoAddress(config.getString("mongodb.uri")))

  sys.addShutdownHook(system.shutdown())
}
