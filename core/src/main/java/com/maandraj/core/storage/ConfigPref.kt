package com.maandraj.core.storage

import com.chibatching.kotpref.KotprefModel

object ConfigPref : KotprefModel() {
    var guideComplete: Boolean by booleanPref(default = false)
}