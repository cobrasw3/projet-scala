package model

import scala.io.Source
import scala.math._

case class Country(id: String, code: String, name: String, continent: String, wikipedia_link: String, keywords: String)

object Country{

def lineparse_Country (CountryArray:Array[String]) : Option[Country] =
{
    if(CountryArray.length != 6) {
      val filledArray = CountryArray.padTo(6, "")

      Some(
        Country(
          filledArray(0), 
          filledArray(1), 
          filledArray(2), 
          filledArray(3), 
          filledArray(4), 
          filledArray(5)
        )
      )
    }
    else{
      Some(
        Country(
          CountryArray(0),
          CountryArray(1),
          CountryArray(2),
          CountryArray(3),
          CountryArray(4),
          CountryArray(5)
        )
      )
    }
  }
}


