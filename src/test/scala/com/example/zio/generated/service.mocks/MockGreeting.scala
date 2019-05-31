package com.example.zio.generated.service.mocks

import scalaz.zio.ZIO
import com.example.zio.generated.services._
import com.example.zio.generated.domain._
import com.example.zio.generated.enums._

object MockGreeting {
  def apply(
             sayHiReturns: Option[Either[Throwable, String]] = None
           ): Greeting = new Greeting {
    override def greetingService: Greeting.Service = new Greeting.Service {

      override def sayHi(
                          person: Person,
                          message: String
                        ): ZIO[Any, Throwable, String] = sayHiReturns match {
        case Some(Right(good)) => ZIO.succeed(good)
        case Some(Left(bad)) => ZIO.fail(bad)
        case _ => throw new NotImplementedError("MockGreeting.sayHi was not defined. Check if sayHiReturns is set on MockGreeting")
      }

    }
  }
}
       