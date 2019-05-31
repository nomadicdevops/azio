package com.example.zio.generated.enums

sealed trait Gender

case object Male extends Gender

case object Female extends Gender

case class NonBinary(pronoun: String) extends Gender
       