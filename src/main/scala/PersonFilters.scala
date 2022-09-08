case class PersonSelections(
    persons: Selection[Person],
    city: Selection[City],
    team: Selection[Team],
  )

object PersonFilters:
  def fromSelections(personSelections: PersonSelections): Filter[Person] =
    Filter.all(
      person(personSelections.persons),
      city(personSelections.city),
      team(personSelections.team),
    )

  private def person(persons: Selection[Person]): Filter[Person] =
    Filter.fromSelection(persons)

  private def team(teams: Selection[Team]): Filter[Person] =
    fromPersonField(_.team)(teams)

  private def city(cities: Selection[City]): Filter[Person] =
    fromPersonField(_.city)(cities)

  private def fromPersonField[B](f: Person => B)(selection: Selection[B]): Filter[Person] =
    val bFilter = Filter.fromSelection(selection)
    Filter.contraMap(f)(bFilter)
