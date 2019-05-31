
package com.example.zio.generated.domain.generators

import org.scalacheck.Gen
import com.example.zio.generated.domain._
import com.example.zio.generated.enum.generators._
import com.example.zio.generated.util._

object PersonGen {
  def apply(): Gen[Person] = for {
    name <- StringGen()
    age <- IntGen()
    gender <- GenderGen()
  } yield {
    Person(
      name = name,
      age = age,
      gender = gender
    )
  }
}
       