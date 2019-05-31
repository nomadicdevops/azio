package com.example.zio.impl.services

import scalaz.zio.ZIO
import com.example.zio.generated.services._
import com.example.zio.generated.domain._
import com.example.zio.generated.enums._

class LiveGreetingService extends Greeting.Service {

	override def sayHi(
		person: Person,
		message: String
	): ZIO[Any, Throwable, String] = ??? //TODO: implement me. Example: ZIO.succeed(s"$message ${person.name}")

}

trait LiveGreeting extends Greeting {
  val greetingService: LiveGreetingService = new LiveGreetingService
}

object LiveGreeting extends LiveGreeting
     