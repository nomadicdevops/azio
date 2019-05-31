name := "azio"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.scalaz" %% "scalaz-zio" % "1.0-RC4"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test

/*
to customize sbt-zio-codegen

zioCodeGenGeneratedPackageName := "whatever.you.want.your.generated.package.to.be"
zioCodeGenGeneratedImplPackageName := "whatever.you.want.your.impl.package.to.be"
zioCodeGenForImpl := false // true by default
zioCodeGenErrorType := "YourErrorType" // suggest to define it in enums

 */