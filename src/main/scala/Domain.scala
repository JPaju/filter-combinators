import java.util.*

type PersonName = String
type Age        = Int
type Team       = String
type City       = String

case class Person(
    id: UUID,
    age: Age,
    name: PersonName,
    team: Team,
    city: City,
  )
