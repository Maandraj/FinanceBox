package com.maandraj.core.storage

import com.chibatching.kotpref.KotprefModel

object ConfigPref : KotprefModel() {
    var pincode: String? by nullableStringPref(default = "")
}