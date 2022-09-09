package fi.jpaju

object PersonFilters:
  val adultAgeRange: Range[Int] = Range.create(18, Int.MaxValue)
  val isAdult: Filter[Person]   = adultAgeRange.toRangeFilter.contramap[Person](_.age)

  val tpsTeamFilter: Filter[Team]     = Filter.fromEquals[Team]("TPS")
  val tpsPersonFilter: Filter[Person] = tpsTeamFilter.contramap[Person](_.team)

  val inaTerm: SearchTerm             = SearchTerm.fromTerm("ina")
  val cityIncludesIna: Filter[String] = Filter.fromPredicate(inaTerm.isIncluded)
  val livesInInaCity: Filter[Person]  = cityIncludesIna.contramap[Person](_.city)
