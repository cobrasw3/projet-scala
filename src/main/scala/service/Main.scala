import model.Country
import model.Runway
import model.Airport

object Main extends App {
   val parser = new service.Parser

   def action(): Unit = {
      val airports = parser.ParseCsv_Airport("src/main/scala/model/airports.csv")
      val countries = parser.ParseCsv_Country("src/main/scala/model/countries.csv")
      val runways = parser.ParseCsv_Runway("src/main/scala/model/runways.csv")

      println("\n")
      println("Make your choice : \n")
      println("For Query press 'Q' \n")
      println("For Reports press 'R' \n")

      val choice_action = scala.io.StdIn.readLine()

      choice_action.toUpperCase() match {

         case "Q" => 
         println("Choose between code or name of the country you want : \n")
         println("For the name press 'N' \n")
         println("For the code press 'C' \n")

         val choice_info = scala.io.StdIn.readLine()

         choice_info.toUpperCase() match {
            case "N" => 
               println("Enter a name of a country : \n")
               val country_name = scala.io.StdIn.readLine()
               val nameToCodeMap = countries.map(country => country.name -> country.code).toMap
               val countryCode = nameToCodeMap.getOrElse(country_name, "Unknown")
               val match_Airports = airports.filter(_.iso_country.equalsIgnoreCase(countryCode))
               val match_Runways = runways.filter(runway => runway.airport_ident.equalsIgnoreCase(countryCode))

               if (match_Airports.nonEmpty) {
                  match_Airports.foreach(println)
                  match_Runways.foreach(println)

               } else {                                                                      
                  println(s"No matching country found for name: $country_name")
               }

            case "C" => 
               println("Enter a code of a country : \n")
               val country_code = scala.io.StdIn.readLine()
               val match_Airports = airports.filter(_.ident.equalsIgnoreCase(country_code))
               val match_Runways = runways.filter(runway => runway.airport_ident.equalsIgnoreCase(country_code))

               if (match_Airports.nonEmpty) {
                  match_Airports.foreach(println)
                  match_Runways.foreach(println)
               } else {
                  println(s"No matching country found for name: $country_code")
               }

            case _ =>
               println("Invalid choice.")
         }

         case "R" => 

            println("Now you can choose what you want to display : \n")
            println("To display top 10 countries with the most airports, press 'T': \n")
            println("To display top 10 countries with the least airports, press 'B': \n")
            println("To display type of runways peer country, press 'S': \n")
            println("To display the top 10 most common latitude, press 'L': \n")

            val choice_display = scala.io.StdIn.readLine()

            choice_display.toUpperCase() match {

               case "T" =>

                  val countAirportByCountry = airports.filter(ligne => ligne.iso_country != "iso_country").groupBy(_.iso_country).mapValues(_.size)
                  val airportSortedTop = countAirportByCountry.toSeq.sortBy(-_._2)

                  println("Top 10 countries with the most airports: \n")

                  airportSortedTop.take(10).foreach { case (country, count) =>
                  println(s"$country: $count airports")
               }

               case "B" =>

                  val countAirportByCountry = airports.filter(ligne => ligne.iso_country != "iso_country").groupBy(_.iso_country).mapValues(_.size)
                  val airportSortedBottom = countAirportByCountry.toSeq.sortBy(_._2)

                  println("Top 10 countries with the least airports: \n")


                  airportSortedBottom.take(10).foreach { case (country, count) =>
                  println(s"$country: $count airports")
               }

               case "S" =>
                  val groupedAirports = airports.groupBy(_.iso_country)
                  val groupedRunways = runways.groupBy(_.airport_ref)

                  countries.foreach { country =>
                     val countryAirports = groupedAirports.getOrElse(country.code, Array.empty[Airport])
                     val countryRunways = countryAirports.flatMap(airport => groupedRunways.getOrElse(airport.id, Array.empty[Runway]))
                     val uniqueRunwaySurfaces = countryRunways.map(_.surface).distinct

                     val result = if (uniqueRunwaySurfaces.isEmpty) {

                        "No runway for this country"

                     } else {

                        uniqueRunwaySurfaces.mkString(", ")
                     }

                     println(s"${country.name} --> $result")
               }

               case "L" =>
                  val groupedRunwaysByLatitude = runways.groupBy(_.le_ident)
                  val sortedRunwaysByLatitude = groupedRunwaysByLatitude.toSeq.sortBy(-_._2.size)

                  println("Top 10 most common runways latitudes:")

                  sortedRunwaysByLatitude.take(10).foreach { case (latitude, runways) =>

                  println(s"Latitude: $latitude, Nombre de fois : ${runways.size}")
               }
               
               case _ => 
               println("Invalid choice.")
            }
         }

      println("Do you want to display something else ? (Y/N)")

      val reponse = scala.io.StdIn.readLine()

      if (reponse.toUpperCase() == "Y"){
         action()
      }else{
         println("See you later !")
      }
   }

   action()
 
}