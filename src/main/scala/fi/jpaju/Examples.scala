package fi.jpaju

import scala.concurrent.duration.DurationInt
import java.time.*

object FilterExamples:
  val adultFilter: Filter[Person] =
    RangeExamples.adultAgeRange.toRangeFilter.contramap[Person](_.age)

  val tpsTeamFilter: Filter[Team] = Filter.fromPredicate(SearchTermExamples.searchTps.isIncluded)
  val tpsPersonFilter: Filter[Person] = tpsTeamFilter.contramap[Person](_.team)

  val liigaTeamFilter: Filter[Team] = Filter.fromPredicate(SelectionExamples.liigaTeams.contains)
  val liigaTeamPersonFilter: Filter[Person] = liigaTeamFilter.contramap[Person](_.team)

object SelectionExamples:
  val liigaTeams = Set(
    "HIFK",
    "HPK",
    "Ilves",
    "JYP",
    "KalPa",
    "Kärpät",
    "KooKoo",
    "Lukko",
    "Pelicans",
    "SaiPa",
    "Sport",
    "Tappara",
    "TPS",
    "Ässät",
  ) // Thx co-pilot

  val liigaSelection: Selection[Team] = Selection.fromCollection(liigaTeams)

  val turunSeutu: Set[String]         = Set("Turku", "Kaarina", "Raisio")
  val turkuSelection: Selection[City] = Selection.fromCollection(turunSeutu)

  val pkSeutu: Set[String]         = Set("Helsinki", "Espoo", "Vantaa")
  val pkSelection: Selection[City] = Selection.fromCollection(pkSeutu)

object RangeExamples:
  val minorRange    = Range.create(0, 18)
  val majorRange    = Range.create(18, 65)
  val seniorRange   = Range.create(65, Int.MaxValue)
  val adultAgeRange = Range.create(18, Int.MaxValue)

  object JavaTime:
    val durationStart = Duration.ofHours(1)
    val durationEnd   = Duration.ofHours(3)
    val durationRange: Range[Duration] =
      Range.create(durationStart, durationEnd)

    val instantStart = Instant.now()
    val instantEnd   = instantStart.plusMillis(3.hours.toMillis)
    val instantRange: Range[Instant] =
      Range.create(instantStart, instantEnd)

    val localDateTimeStart = LocalDateTime.now()
    val localDateTimeEnd   = localDateTimeStart.plusHours(3)
    val localDateTimeRange: Range[LocalDateTime] =
      Range.create(localDateTimeStart, localDateTimeEnd)

    val localDateStart = LocalDate.now()
    val localDateEnd   = localDateStart.plusDays(3)
    val localDateRange: Range[LocalDate] =
      Range.create(localDateStart, localDateEnd)

    val offsetDateTimeStart = OffsetDateTime.now()
    val offsetDateTimeEnd   = offsetDateTimeStart.plusHours(3)
    val offsetDateTimeRange: Range[OffsetDateTime] =
      Range.create(offsetDateTimeStart, offsetDateTimeEnd)

object SearchTermExamples:
  val searchTps: SearchTerm = SearchTerm.fromTerm("TPS")
