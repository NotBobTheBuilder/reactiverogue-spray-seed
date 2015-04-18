package com.example.core

import com.example.api.Api

object Main extends App with Api with Core {
  run(8080)
}
