import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build
{
  val appName         = "spring-security-scala"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,

    // Spring security
    "org.springframework.security" % "spring-security-core" % "3.1.3.RELEASE",
    "org.springframework.security" % "spring-security-web" % "3.1.3.RELEASE",
    "org.springframework.security" % "spring-security-config" % "3.1.3.RELEASE",
//    "org.springframework.security" % "spring-security-openid" % "3.1.3.RELEASE",

    // Spring
//    "org.springframework" % "spring-core" % "3.2.2.RELEASE",
//    "org.springframework" % "spring-context" % "3.2.2.RELEASE",
//    "org.springframework" % "spring-beans" % "3.2.2.RELEASE",
//    "org.springframework" % "spring-web" % "3.2.2.RELEASE"
//    "org.springframework" % "spring-jdbc" % "3.2.2.RELEASE",
//    "org.springframework" % "spring-tx" % "3.2.2.RELEASE",
//
//    "javax.servlet" % "servlet-api" % "2.5"

      "cglib" % "cglib" % "2.2"

  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    organization := "com.amelco"
  )


}