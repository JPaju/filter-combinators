import java.util.UUID
def program =
  val name: PersonName = "name"
  val city: City       = "Turku"
  val team: Team       = "TPS"

  val person = Person(UUID.randomUUID(), 20, name, team, city)

  val personSelections = PersonSelections(
    Selection.empty,
    Selection.from(person.city),
    Selection.from(person.team),
  )

  val personFilter = PersonFilters.fromSelections(personSelections)
  val passesFilter = person ? personFilter
  println(s"Passes person filter: $passesFilter")

  val adultAgeRange = Range.create(18, Int.MaxValue)
  val isAdultFilter = Filter.contraMap((_: Person).age)(adultAgeRange.toFilter)
  val isAdult       = person ? isAdultFilter
  println(s"Passes age filter: $isAdult")

  val searchTps: SearchTerm           = SearchTerm.fromTerm("TPS")
  val tpsTeamFilter: Filter[Team]     = Filter.fromPredicate(searchTps.isIncluded)
  val tpsPersonFilter: Filter[Person] = Filter.contraMap((_: Person).team)(tpsTeamFilter)
  val isInTps                         = person ? tpsPersonFilter
  println(s"Passes TPS filter: $isInTps")

end program

@main
def main =
  println(Console.CYAN)
  program
  println(Console.RESET)
