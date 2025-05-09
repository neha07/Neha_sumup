package com.sumup.challenge.toastcatalog.utils
import java.text.SimpleDateFormat
import java.util.*

fun String?.formatLastSold(): String {
    return try {
        if (this.isNullOrBlank()) return "Last sold: Unknown"

        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val date = inputFormat.parse(this)

        val outputFormat = SimpleDateFormat("MM/dd/yy, h:mm a", Locale.getDefault())
        " ${outputFormat.format(date)} "
    } catch (e: Exception) {
        "Last sold: Unknown"
    }
}