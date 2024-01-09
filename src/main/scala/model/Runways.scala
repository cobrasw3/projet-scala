package model

import scala.io.Source
import scala.math._

case class Runway(id: String, airport_ref: String, airport_ident: String, length_ft: String, width_ft: String, surface: String, lighted: String, closed: String, le_ident: String, le_latitude_deg: String, le_longitude_deg: String, le_elevation_ft: String, le_heading_degT: String, le_displaced_threshold_ft: String, he_ident: String, he_latitude_deg: String, he_longitude_deg: String, he_elevation_ft: String, he_heading_degT: String, he_displaced_threshold_ft: String)

object Runway{

def lineparse_Runway (RunwayArray:Array[String]) : Option[Runway] =
{
    if(RunwayArray.length != 20) {
      val filledArray = RunwayArray.padTo(20, "")

      Some(
        Runway(
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
          filledArray(17), 
          filledArray(18), 
          filledArray(19)
        )
      )
    }else{
      Some(
        Runway(
          RunwayArray(0), 
          RunwayArray(1), 
          RunwayArray(2), 
          RunwayArray(3), 
          RunwayArray(4), 
          RunwayArray(5), 
          RunwayArray(6), 
          RunwayArray(7), 
          RunwayArray(8), 
          RunwayArray(9), 
          RunwayArray(10), 
          RunwayArray(11), 
          RunwayArray(12), 
          RunwayArray(13), 
          RunwayArray(14), 
          RunwayArray(15), 
          RunwayArray(16), 
          RunwayArray(17), 
          RunwayArray(18), 
          RunwayArray(19)
        )
      )
    }
  }
}


