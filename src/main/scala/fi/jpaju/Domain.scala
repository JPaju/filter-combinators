package fi.jpaju

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

object Person:
  def create(
      age: Age,
      name: PersonName,
      team: Team,
      city: City,
    ): Person =
    Person(UUID.randomUUID(), age, name, team, city)
