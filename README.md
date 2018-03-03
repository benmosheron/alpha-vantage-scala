# alpha-vantage-scala
### A Basic Wrapper around the Alpha Vantage Data API

Version 0.0.1

AVS supports the daily time series data API.

To create an API instance you will need to pass in API key.
Optional constructor arguments are:
* outputSize: Either "full" (default) or "compact". This parameter will be passed to the API as the `outputsize` query string parameter.
* logger: A scalalogging logger.  By default a new scalalogging logger will be instantiated.

```
import avs.Api

val api = new Api(key)
```
Calling the API, and accessing the data is easy. The result contains two Option fields:
* timeSeries: A wrapper around a Vector of PriceDate instances, sorted by date (oldest first). `None` if the response cannot be parsed.
* rawJson: The unaltered JSON returned by Alpha Vantage (this is in keeping with Alpha Vantage's wishes that open source projects preserve the content of JSON responses in both success and failure cases). `None` if the API could not be called.
```
// Get a daily time series for the share price of Microsoft, which uses the symbol MSFT.
val result = api.timeSeriesDaily("MSFT")
```
The TimeSeriesDaily returned is Vector of simple case classes:
```
// Let's print the opening prices.
result.timeSeries match {
  case None => println("It didn't work! Check input parameters, or rawJson.")
  case Some(ts) => ts.prices.map(p => p.price.open).foreach(println)
}
```

Neither I, nor this project, are associated with Alpha Vantage.