lazy val root = (project in file(".")).
  settings(
    organization := "org.openapitools",
    name := "openapi-java-client",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.11.4",
    scalacOptions ++= Seq("-feature"),
    javacOptions in compile ++= Seq("-Xlint:deprecation"),
    publishArtifact in (Compile, packageDoc) := false,
    resolvers += Resolver.mavenLocal,
    libraryDependencies ++= Seq(
      "io.swagger" % "swagger-annotations" % "1.6.6",
      "io.rest-assured" % "rest-assured" % "4.5.1",
      "io.rest-assured" % "scala-support" % "4.5.1",
      "com.google.code.findbugs" % "jsr305" % "3.0.2",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.13.4",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.13.4",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.13.4.2",
      "org.openapitools" % "jackson-databind-nullable" % "0.2.6",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.13.4.1",
      "com.squareup.okio" % "okio" % "1.17.5" % "compile",
    "jakarta.annotation" % "jakarta.annotation-api" % "1.3.5" % "compile",
      "org.junit.jupiter" % "junit-jupiter-api" % "5.10.3" % "test",
      "com.novocode" % "junit-interface" % "0.10" % "test"
    )
  )
