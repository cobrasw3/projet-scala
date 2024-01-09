package service

import model.Airport.lineparse_Airport
import model.Airport

import model.Country.lineparse_Country
import model.Country

import model.Runway.lineparse_Runway
import model.Runway

import scala.io.Source

class Parser {

  def ParseCsv_Airport(filepath: String, separator: String = ","): Array[Airport] = {
    val lines = Source.fromFile(filepath, "UTF-8")
    val lines_splitted = lines.getLines.map(line => line.split(separator).map(_.replaceAll("\"", "").trim))
    val airports = lines_splitted.flatMap(lineparse_Airport)
    airports.toArray
  }

  def ParseCsv_Country(filepath: String, separator: String = ","): Array[Country] = {
    val lines = Source.fromFile(filepath, "UTF-8")
    val lines_splitted = lines.getLines.map(line => line.split(separator).map(_.replaceAll("\"", "").trim))
    val countries = lines_splitted.flatMap(lineparse_Country)
    countries.toArray
  }

  def ParseCsv_Runway(filepath: String, separator: String = ","): Array[Runway] = {
    val lines = Source.fromFile(filepath, "UTF-8")
    val lines_splitted = lines.getLines.map(line => line.split(separator).map(_.replaceAll("\"", "").trim))
    val runways = lines_splitted.flatMap(lineparse_Runway)
    runways.toArray
  }
}

