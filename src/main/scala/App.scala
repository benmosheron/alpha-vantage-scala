import avs.Api
import better.files.File

// App to conveniently test the API from the command line.
// Will be removed.
object App {
  def main(args: Array[String]): Unit = {
    // Let's get our key
    val key = File("/Users/bensheron/.key/alpha-vantage").contentAsString.trim
    val api = new Api(key)
    // Optionally pass in a symbol
    val symbol = if(args.nonEmpty) args(0) else "MSFT"
    val test = api.timeSeriesDaily(symbol)

    // Do some stuff
//    println(test.timeSeries.get.metadata)
//    println(test.rawJson)
  }
}
