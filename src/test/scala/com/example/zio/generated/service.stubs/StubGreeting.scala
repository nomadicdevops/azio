package com.example.zio.generated.service.stubs

import com.example.zio.generated.services._

object StubGreeting {
  def apply(
             serviceStub: Greeting.Service
           ): Greeting = new Greeting {
    override def greetingService: Greeting.Service = serviceStub
  }
}
       