package fi.jpaju

import scala.concurrent.duration.DurationInt
import java.time.*

object TimeRanges:
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
