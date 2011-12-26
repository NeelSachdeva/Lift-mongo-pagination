import sbt._

class LiftProject(info: ProjectInfo) extends DefaultWebProject(info) {
  val liftVersion = "2.4-M4"

  /**
   * Application dependencies
   */
  val webkit = "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default"
  val logback = "ch.qos.logback" % "logback-classic" % "0.9.26" % "compile->default"

  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided->default"
  val jetty6 = "org.mortbay.jetty" % "jetty" % "6.1.22" % "test->default"
  val junit = "junit" % "junit" % "4.5" % "test->default"
  /*val specs     = "org.scala-tools.testing" %% "specs" % "1.6.6" % "test->default"*/
  val specs = "org.scala-tools.testing" % "specs_2.9.1" % "1.6.9"
  val mapper = "net.liftweb" %% "lift-mapper" % liftVersion
  // val lift_widgets  = "net.liftweb" %% "lift-widgets" % liftVersion
  //val lift_widgets  = "net.liftweb" %% "lift-widgets" % liftVersion
  //val dependency = "net.liftweb" %"lift-widgets" %"2.0"
  val liftWidgets = "net.liftweb" %% "lift-widgets" % liftVersion % "compile->default"
  val liftTextile = "net.liftweb" %% "lift-textile" % liftVersion % "compile->default"
  val liftWizard = "net.liftweb" %% "lift-wizard" % liftVersion
   //val mongo=    "net.liftweb" %%"ift-mongodb_2.8.0" % 2.4-M4
  //val mongorecord =    "net.liftweb" %%"lift-mongodb-record_2.8.0" % 2.4-M4
  val casbah = "com.mongodb.casbah" % "casbah_2.8.0" % "2.0"
 // val lift_mongo_record = "net.liftweb" %% "lift-mongodb-record_2.8.0" % "2.4-M2"
  val lift_mongo = "net.liftweb" %% "lift-mongodb-record" % liftVersion

  /**
   *
   * Maven repositories
   */
  lazy val scalatoolsSnapshots = ScalaToolsSnapshots
}
