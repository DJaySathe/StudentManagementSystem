name := """FirstPlayProject"""
organization := "ncsu"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.4"

libraryDependencies += guice

libraryDependencies += javaJdbc

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.12"

lazy val myProject = (project in file("."))
  .enablePlugins(PlayJava, PlayEbean)