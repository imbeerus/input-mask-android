package com.redmadrobot.inputmask.extensions

import android.widget.EditText
import com.redmadrobot.inputmask.model.Notation

fun EditText.setNotationMaskWatcher(
        notation: Notation,
        mask: String
) {
    setNotationMaskWatcher(listOf(notation), mask)
}

fun EditText.setNotationMaskWatcher(
        notations: List<Notation>,
        mask: String
) {
    if (mask.isEmpty()) {
        throw IllegalStateException("$mask shouldn't be empty")
    }

    installOn(
            customNotations = notations,
            primaryFormat = mask
    )
}