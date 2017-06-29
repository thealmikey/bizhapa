scalaVersion := "2.11.8"

enablePlugins(AndroidApp, RoomPlugin)

android.useSupportVectors

versionCode := Some(1)

version := "0.1-SNAPSHOT"

resolvers += "google architecture" at "https://maven.google.com"

platformTarget := "android-26"

javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

scalacOptions ++= Seq("-feature", "-Xexperimental" ,"-language:implicitConversions", "-language:postfixOps", "-target:jvm-1.7")

libraryDependencies += "com.android.support" % "recyclerview-v7" %"25.0.0"




useProguard := false

proguardScala := false

javaOptions in Compile := Seq("-Xmx2G")


libraryDependencies ++= Seq(
  "android.arch.lifecycle"%"runtime"%"1.0.0-alpha3",
  "android.arch.lifecycle"%"extensions"%"1.0.0-alpha3")


addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies += "com.android.support" % "multidex" % "1.0.0"

libraryDependencies += "com.lucidchart" %% "android-room" % "0-SNAPSHOT"
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

proguardOptions ++= Seq("-keepclasseswithmembernames class android.arch.room.** { *; }")

dexMulti := true

dexMaxHeap := "4g"

dexMainClasses := Seq(
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