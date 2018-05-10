name := "highperfscala"
organization := "highperfscala"

val scalazVersion = "7.2.22"
val specsVersion = "4.2.0"

val slf4s = "org.slf4s" %% "slf4s-api" % "1.7.25"
val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"
val hdrHistogram = "org.mpierce.metrics.reservoir" %
  "hdrhistogram-metrics-reservoir" % "1.1.0"
val scalaz = "org.scalaz" %% "scalaz-core" % scalazVersion
val scalazConcurrent = "org.scalaz" %% "scalaz-concurrent" % scalazVersion
val specs2 = "org.specs2" %% "specs2-core" % specsVersion
val specs2ScalaCheck = "org.specs2" %% "specs2-scalacheck" % specsVersion
val joda = "joda-time" % "joda-time" % "2.9.9"
val jodaConvert = "org.joda" % "joda-convert" % "2.0.1"
val breeze = "org.scalanlp" %% "breeze" % "1.0-RC2" exclude(
  "org.spire-math", "spire_2.12")
val spire = "org.typelevel" %% "spire" % "0.15.0"
val spireMacro = "org.typelevel" %% "spire-macros" % "0.15.0"
val saddle = "io.github.pityka" %% "saddle-core-fork" % "1.3.4-fork1"


val baseOptions = Defaults.coreDefaultSettings ++ Seq(
  scalaVersion := "2.12.5",
  fork := true,
  resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  libraryDependencies ++= List(
    slf4s, scalaCheck, hdrHistogram, scalaz, joda, jodaConvert,
    specs2 % "test", specs2ScalaCheck % "test"
  )
)

lazy val root = project
  .settings(
    name := "highperfscala",
    baseOptions ++ Seq(
      onLoadMessage ~= (_ + (if (sys.props("java.specification.version") != "1.8") {
        """
          |You seem to not be running Java 1.8.
          |While the provided code may still work, we recommend that you
          |upgrade your version of Java.
        """.stripMargin
      } else "")))
  )

lazy val chapter2 = project
  .settings(
    name := "chapter2",
    baseOptions
  ).enablePlugins(JmhPlugin)

lazy val chapter3 = project
  .settings(
    name := "chapter3",
    baseOptions
  ).enablePlugins(JmhPlugin)


lazy val chapter4 = project
  .settings(
    name := "chapter4",
    baseOptions
  ).settings(
  libraryDependencies ++= Seq(breeze, spire, spireMacro, saddle)
).enablePlugins(JmhPlugin)

lazy val chapter5 = project
  .settings(
    name := "chapter5",
    baseOptions
  ).enablePlugins(JmhPlugin)

lazy val chapter6 = project
  .settings(
    name := "chapter6",
    baseOptions
  ).settings(
  libraryDependencies ++= Seq(scalazConcurrent)
).enablePlugins(JmhPlugin)

lazy val chapter7 = project
  .settings(
    name := "chapter7",
    baseOptions
  ).settings(
  libraryDependencies ++= Seq(scalazConcurrent)
).enablePlugins(JmhPlugin)
