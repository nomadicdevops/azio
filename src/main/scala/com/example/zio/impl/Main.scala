
package com.example.zio.impl

import scalaz.zio.internal.PlatformLive
import scalaz.zio.{Runtime, ZIO}
import com.example.zio.generated.domain._
import com.example.zio.generated.services._
import com.example.zio.generated.enums._
import com.example.zio.impl.services._

object Main extends App {

  type ProgramEnv = Greeting
  val programEnv: ProgramEnv = new LiveGreeting {}

  val program: ZIO[ProgramEnv, Throwable, Unit] = ??? //TODO: implement me
  // Example:
  /*
  val program: ZIO[ProgramEnv, Throwable, Unit] =
    for {
      greeting <- GreetingProvider.sayHi(
        person = Person(
          name = "Alex",
          age = 42,
          gender = Male
        ),
        message = "Hello")
    } yield {
      println(greeting)
    }
  */

  val runtime: Runtime[ProgramEnv] = Runtime(programEnv, PlatformLive.Default)

  runtime
    .unsafeRun(program.either)
    .fold(_ => 1, _ => 0)

}

       