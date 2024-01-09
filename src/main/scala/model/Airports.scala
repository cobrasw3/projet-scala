package model

import scala.io.Source
import scala.math._

case class Airport(id: String, ident: String, `type`: String, name: String, latitude_deg: String, longitude_deg: String, elevation_ft: String, continent: String, iso_country: String, iso_region: String, municipality: String, scheduled_service: String, gps_code: String, iata_code: String, local_code: String, home_link: String, wikipedia_link: String, keywords: String)
 
object Airport {
  def lineparse_Airport(AirportArray: Array[String]): Option[Airport] = {
    if (AirportArray.length != 18) {
      val filledArray = AirportArray.padTo(18, "")
      
      Some(
        Airport(
          filledArray(0),
          filledArray(1),
          filledArray(2),
          filledArray(3),
          filledArray(4),
          filledArray(5),
          filledArray(6),
          filledArray(7),
          filledArray(8),
          filledArray(9),
          filledArray(10),
          filledArray(11),
          filledArray(12),
          filledArray(13),
          filledArray(14),
          filledArray(15),
          filledArray(16),
          filledArray(17)
        )
      )
    } else {
      Some(
        Airport(
          AirportArray(0),
          AirportArray(1),
          AirportArray(2),
          AirportArray(3),
          AirportArray(4),
          AirportArray(5),
          AirportArray(6),
          AirportArray(7),
          AirportArray(8),
          AirportArray(9),
          AirportArray(10),
          AirportArray(11),
          AirportArray(12),
          AirportArray(13),
          AirportArray(14),
          AirportArray(15),
          AirportArray(16),
          AirportArray(17)
        )
      )
    }
  }
}