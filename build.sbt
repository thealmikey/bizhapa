scalaVersion := "2.11.8"

enablePlugins(AndroidApp)

android.useSupportVectors

versionCode := Some(1)

version := "0.1-SNAPSHOT"

resolvers += "google architecture" at "https://maven.google.com"

platformTarget := "android-26"

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

scalacOptions ++= Seq("-feature", "-Xexperimental" ,"-language:implicitConversions", "-language:postfixOps", "-target:jvm-1.7")

libraryDependencies += "com.android.support" % "recyclerview-v7" %"25.0.0"




useProguard := true


proguardScala := true

javaOptions in Compile := Seq("-Xmx2G")


libraryDependencies ++= Seq(
  "android.arch.lifecycle"%"runtime"%"1.0.0-alpha3",
  "android.arch.lifecycle"%"extensions"%"1.0.0-alpha3")


addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

//for Room database
libraryDependencies += "android.arch.persistence.room" % "runtime" % "1.0.0-alpha3"

libraryDependencies += "android.arch.persistence.room" % "compiler" % "1.0.0-alpha3"

libraryDependencies += "com.android.support" % "multidex" % "1.0.0"

libraryDependencies += "com.lucidchart" %% "android-room" % "0-SNAPSHOT"
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)