package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {
	val httpConf = http
	.baseURL("http://www.local.sciencedirect.com:5048")
	.userAgentHeader("AIP Load Test")

	val scn = scenario("Article In Press Page")
	.exec(http("request_to_article_in_press page")
	.get("/journal/journal-of-the-taiwan-institute-of-chemical-engineers/articles-in-press"))

	setUp(scn.inject(constantUsersPerSec(3).during(1 minutes)).protocols(httpConf))
}