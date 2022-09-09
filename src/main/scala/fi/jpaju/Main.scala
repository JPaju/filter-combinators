package fi.jpaju

import java.util.UUID

def testPerson(person: Person) =
  val name = person.name
  println(s"$name is adult: ${person ? PersonFilters.isAdult}")
  println(s"$name plays in TPS: ${person ? PersonFilters.tpsPersonFilter}")
  println(s"$name lives in city containing 'ina': ${person ? PersonFilters.livesInInaCity}")

def program() =
  val name: PersonName = "name"

  val person1 = Person.create(
    age = 20,
    name = "Good player",
    team = "TPS",
    city = "Kaarina",
  )

  val person2 = Person.create(
    age = 16,
    name = "Average player",
    team = "HPK",
    city = "Forssa",
  )

  testPerson(person1)
  testPerson(person2)

end program

@main
def main =
  println(Console.CYAN)
  program()
  println(Console.RESET)
