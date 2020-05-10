package com.redmadrobot.inputmask.extensions

import android.widget.EditText
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.model.Notation

fun EditText.setMaskWatcher(listener: MaskedTextChangedListener) {
    addTextChangedListener(listener)
    onFocusChangeListener = listener
}

fun EditText.setNotationMaskWatcher(
        notations: List<Notation>,
        mask: String
) {
    val notationsListener = notations.buildMaskWatcher(this, mask)
    setMaskWatcher(notationsListener)
}