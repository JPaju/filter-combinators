package fi.jpaju

case class PersonSelections(
    persons: Selection[Person],
    cities: Selection[City],
    teams: Selection[Team],
  )

object PersonFilters:
  def fromSelections(selections: PersonSelections): Filter[Person] =
    Filter.all(
      selections.persons.toSelectionFilter,
      selections.cities.toSelectionFilter.contramap(_.city),
      selections.teams.toSelectionFilter.contramap(_.team),
    )
