package com.redmadrobot.inputmask.extensions

import android.widget.EditText
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.model.Notation

fun List<Notation>.buildMaskWatcher(
        field: EditText,
        mask: String
): MaskedTextChangedListener {
    if (mask.isEmpty()) {
        throw IllegalStateException("$mask shouldn't be empty")
    }

    return MaskedTextChangedListener(
            customNotations = this,
            primaryFormat = mask,
            field = field
    )
}