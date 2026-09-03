package eu.kanade.presentation.track.local

import dev.icerock.moko.resources.StringResource
import tachiyomi.domain.track.local.model.LocalReadingStatus
import tachiyomi.i18n.MR

fun LocalReadingStatus.stringRes(): StringResource = when (this) {
    LocalReadingStatus.READING -> MR.strings.status_reading
    LocalReadingStatus.COMPLETED -> MR.strings.status_completed
    LocalReadingStatus.PLAN_TO_READ -> MR.strings.status_plan_to_read
    LocalReadingStatus.ON_HOLD -> MR.strings.status_on_hold
}
