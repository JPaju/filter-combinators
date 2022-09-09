package fi.jpaju

import java.util.UUID

def program =
  val name: PersonName = "name"
  val city: City       = "Turku"
  val team: Team       = "TPS"

  val person = Person(UUID.randomUUID(), 20, name, team, city)

  val personSelections = PersonSelections(
    Selection.empty,
    Selection.singleton(person.city),
    Selection.singleton(person.team),
  )

  val filterFromSelections = PersonFilters.fromSelections(personSelections)
  println(s"Passes person filter: ${person ? filterFromSelections}")
  println(s"Passes age filter: ${person ? FilterExamples.adultFilter}")
  println(s"Passes team filter: ${person ? FilterExamples.tpsPersonFilter}")

end program

@main
def main =
  println(Console.CYAN)
  program
  println(Console.RESET)
