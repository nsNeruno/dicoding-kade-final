package dev.neruno.lab.footballapps.utilities

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class Utilities {

    companion object {
        @JvmStatic
        fun reformatDateString(dateString: String, originalFormat: String, destFormat: String): String {
            return try {
                val locale = Locale.ENGLISH
                val date = SimpleDateFormat(originalFormat, locale).parse(dateString)
                SimpleDateFormat(destFormat, locale).format(date)
            } catch (ex: ParseException) {
                dateString
            }
        }

        @JvmStatic
        fun cleanSportsDbApiString(str: String?): String {
            var newStr = ""
            str?.split(";")?.forEach {
                newStr += "${it.trim()}\n"
            }
            return newStr
        }
    }
}