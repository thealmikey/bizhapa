import scala.io

scalaVersion := "2.11.8"

enablePlugins(AndroidApp)

android.useSupportVectors

versionCode := Some(1)

version := "0.1-SNAPSHOT"

instrumentTestRunner :=
  "android.support.test.runner.AndroidJUnitRunner"

platformTarget := "android-25"

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

scalacOptions ++= Seq("-feature", "-Xexperimental" ,"-language:implicitConversions", "-language:postfixOps", "-target:jvm-1.7")

libraryDependencies ++=
  "com.android.support"%"design"%"25.0.0"::
    "com.android.support"%"gridlayout-v7"%"25.0.0"::
    "com.android.support" % "cardview-v7" % "25.0.0"::
        "com.android.support" % "appcompat-v7" % "25.0.0" ::
    Nil

libraryDependencies += "com.android.support" % "recyclerview-v7" %"25.0.0"

// https://mvnrepository.com/artifact/org.sqldroid/sqldroid
//libraryDependencies += "org.sqldroid" % "sqldroid" % "1.0.3"

useProguard := false

//proguardOptions ++= io.Source.fromFile("proguard/proguard-sbt.txt").getLines().toSeq


proguardScala := false

javaOptions in Compile := Seq("-Xmx2G")

//javacOptions ++= Seq("-processor", "android.arch.lifecycle.compiler", "-proc:only")
//
//javacOptions ++= Seq("-processor", "android.arch.persistence.compiler", "-proc:only")
//
//compileOrder := CompileOrder.JavaThenScala


dexMulti := true

resolvers += "Google android repo" at "https://maven.google.com"

//For Lifecycles, LiveData, and ViewModel
libraryDependencies ++= Seq(
  "android.arch.lifecycle"%"runtime"%"1.0.0-alpha1",
  "android.arch.lifecycle"%"extensions"%"1.0.0-alpha1",
  "android.arch.lifecycle"%"compiler"%"1.0.0-alpha1"
)

//for Room database
libraryDependencies ++= Seq(
  "android.arch.persistence.room" % "runtime" % "1.0.0-alpha1",
  "android.arch.persistence.room" % "compiler" % "1.0.0-alpha1"
)

libraryDependencies += "com.android.support" % "multidex" % "1.0.1"

dexMainClasses := Seq(
  "com/bizhapa",
  "android/support/multidex/BuildConfig.class",
  "android/support/multidex/MultiDex$V14.class",
  "android/support/multidex/MultiDex$V19.class",
  "android/support/multidex/MultiDex$V4.class",
  "android/support/multidex/MultiDex.class",
  "android/support/multidex/MultiDexApplication.class",
  "android/support/multidex/MultiDexExtractor$1.class",
  "android/support/multidex/MultiDexExtractor.class",
  "android/support/multidex/ZipUtil$CentralDirectory.class",
  "android/support/multidex/ZipUtil.class")
