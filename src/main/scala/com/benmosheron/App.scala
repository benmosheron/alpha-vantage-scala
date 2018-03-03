package com.benmosheron

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
    val result = api.timeSeriesDaily(symbol)

    result.timeSeries.get.prices.map(p => p.price.open).foreach(println)

    result.timeSeries match {
      case None => println("It didn't work! Check input parameters, or rawJson")
      case Some(ts) => ts.prices.map(p => p.price.open).foreach(println)
    }

    // Do some stuff
//    println(result.timeSeries.get.metadata)
//    println(result.rawJson)
  }
}
