
package com.example.zio.generated.service.mock.specs

import com.example.zio.generated.domain._
import com.example.zio.generated.domain.generators._
import com.example.zio.generated.enum.generators._
import com.example.zio.generated.util._
import com.example.zio.generated.enums._
import com.example.zio.generated.service.mocks._
import com.example.zio.generated.services._
import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import scalaz.zio.internal.PlatformLive
import scalaz.zio.{Runtime, ZIO}


object MockGreetingSpec extends Properties("MockGreetingSpec") {

  property("mock Greeting success spec") = forAll(
    StringGen(),
    PersonGen(),
    StringGen()
  ) {
    (
      sayHi: String,
      sayHi_person: Person,
      sayHi_message: String
    ) =>

      type ProgramEnv = Greeting
      val programEnv: ProgramEnv = MockGreeting(
        sayHiReturns = Option(Right(sayHi))
      )
      val runtime: Runtime[ProgramEnv] = Runtime(programEnv, PlatformLive.Default)


      val sayHiProgram: ZIO[ProgramEnv, Throwable, String] =
        for {
          res <- GreetingProvider.sayHi(
            sayHi_person,
            sayHi_message
          )
        } yield {
          res
        }
      runtime.unsafeRun(sayHiProgram.either) == Right(sayHi)
  }


  property("mock Greeting failure spec") = forAll(
    ThrowableGen(),
    PersonGen(),
    StringGen()
  ) {
    (
      err: Throwable,
      sayHi_person: Person,
      sayHi_message: String
    ) =>

      type ProgramEnv = Greeting
      val programEnv: ProgramEnv = MockGreeting(
        sayHiReturns = Option(Left(err))
      )
      val runtime: Runtime[ProgramEnv] = Runtime(programEnv, PlatformLive.Default)


      val sayHiProgram: ZIO[ProgramEnv, Throwable, String] =
        for {
          res <- GreetingProvider.sayHi(
            sayHi_person,
            sayHi_message
          )
        } yield {
          res
        }
      runtime.unsafeRun(sayHiProgram.either) == Left(err)
  }
}
 