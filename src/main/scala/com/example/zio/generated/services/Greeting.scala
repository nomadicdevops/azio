package com.example.zio.generated.services

import scalaz.zio.ZIO
import com.example.zio.generated.domain._
import com.example.zio.generated.enums._

object Greeting {
  trait Service {
    
	def sayHi(
		person: Person,
		message: String
	): ZIO[Any, Throwable, String]
           
  }
}

trait Greeting {
  def greetingService: Greeting.Service
}

object GreetingProvider {
        
	def sayHi(
		person: Person,
		message: String
	): ZIO[Greeting, Throwable, String] =
    ZIO.accessM(_.greetingService.sayHi(person, message))
                 
}
       