package com.example.zio.generated.enum.generators

import org.scalacheck.Gen
import com.example.zio.generated.enums._
import com.example.zio.generated.util._

object GenderGen {
  def apply(): Gen[Gender] = for {
    pronoun <- StringGen()
    enum <- Gen.oneOf(Seq(
      Male,
      Female,
      NonBinary(
        pronoun = pronoun
      )
    ))
  } yield enum
}
       