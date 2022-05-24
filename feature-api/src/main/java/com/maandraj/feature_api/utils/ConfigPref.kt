package com.maandraj.feature_api.utils

import com.chibatching.kotpref.KotprefModel

object ConfigPref : KotprefModel() {
    var guideComplete: Boolean by booleanPref(default = false)
}