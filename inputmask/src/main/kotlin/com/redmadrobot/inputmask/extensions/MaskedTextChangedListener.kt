package com.redmadrobot.inputmask.extensions

import android.text.TextWatcher
import android.widget.EditText
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy
import com.redmadrobot.inputmask.model.Notation

fun EditText.installOn(
        primaryFormat: String,
        affinityCalculationStrategy: AffinityCalculationStrategy = AffinityCalculationStrategy.WHOLE_STRING,
        affineFormats: List<String> = emptyList(),
        customNotations: List<Notation> = emptyList(),
        listener: TextWatcher? = null,
        valueListener: MaskedTextChangedListener.ValueListener? = null,
        autocomplete: Boolean = true,
        autoSkip: Boolean = false,
        addHint: Boolean = false
) {
    val maskedListener = MaskedTextChangedListener(
            field = this,
            primaryFormat = primaryFormat,
            affineFormats = affineFormats,
            customNotations = customNotations,
            affinityCalculationStrategy = affinityCalculationStrategy,
            autocomplete = autocomplete,
            autoskip = autoSkip,
            listener = listener,
            valueListener = valueListener
    )
    addMaskedTextChangedListener(maskedListener, addHint)
}

private fun EditText.addMaskedTextChangedListener(
        listener: MaskedTextChangedListener,
        addHint: Boolean = false
) {
    addTextChangedListener(listener)
    onFocusChangeListener = listener
    if (addHint) {
        hint = listener.placeholder()
    }
}