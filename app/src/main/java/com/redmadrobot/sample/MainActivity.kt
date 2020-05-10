package com.redmadrobot.sample

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.extensions.installOn
import com.redmadrobot.inputmask.extensions.setNotationMaskWatcher
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy
import com.redmadrobot.inputmask.model.Notation

/**
 * Home screen for the sample app.
 *
 * @author taflanidi
 */
class MainActivity : AppCompatActivity() {

    companion object {

        private const val PHONE_NUMBER_PRIMARY_FORMAT = "+7 ([000]) [000]-[00]-[00]"
        private const val ROMAN_NUMERALS_PRIMARY_FORMAT = "[XXXXXX]"

        private const val ROMAN_NUMERALS_CHAR = 'X'
        private const val ROMAN_NUMERALS_CHARACTER_SET = "IVXMCLD"

        private const val PREFIX_SAMPLE_AFFINE_FORMATS = "8 ([000]) [000]-[00]-[00]"
        private const val SUFFIX_SAMPLE_AFFINE_FORMATS = "+7 ([000]) [000]-[00]-[00]#[000]"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPrefixSample()
        setupSuffixSample()
        setupRomanNumeralsSample()
    }

    private fun setupPrefixSample() {
        val editText = findViewById<EditText>(R.id.prefix_edit_text)
        val checkBox = findViewById<CheckBox>(R.id.prefix_check_box)

        val affineFormats = listOf(PREFIX_SAMPLE_AFFINE_FORMATS)

        editText.installOn(
                addHint = true,
                primaryFormat = PHONE_NUMBER_PRIMARY_FORMAT,
                affineFormats = affineFormats,
                affinityCalculationStrategy = AffinityCalculationStrategy.PREFIX,
                valueListener = object : MaskedTextChangedListener.ValueListener {
                    override fun onTextChanged(maskFilled: Boolean, extractedValue: String, formattedValue: String) {
                        logValueListener(maskFilled, extractedValue, formattedValue)
                        checkBox.isChecked = maskFilled
                    }
                }
        )
    }

    private fun setupSuffixSample() {
        val editText = findViewById<EditText>(R.id.suffix_edit_text)
        val checkBox = findViewById<CheckBox>(R.id.suffix_check_box)

        val affineFormats = listOf(SUFFIX_SAMPLE_AFFINE_FORMATS)

        editText.installOn(
                addHint = true,
                primaryFormat = PHONE_NUMBER_PRIMARY_FORMAT,
                affineFormats = affineFormats,
                affinityCalculationStrategy = AffinityCalculationStrategy.WHOLE_STRING,
                valueListener = object : MaskedTextChangedListener.ValueListener {
                    override fun onTextChanged(maskFilled: Boolean, extractedValue: String, formattedValue: String) {
                        logValueListener(maskFilled, extractedValue, formattedValue)
                        checkBox.isChecked = maskFilled
                    }
                })
    }

    private fun setupRomanNumeralsSample() {
        val editText = findViewById<EditText>(R.id.date_edit_text)

        val romanNotation = Notation(
                character = ROMAN_NUMERALS_CHAR,
                characterSet = ROMAN_NUMERALS_CHARACTER_SET,
                isOptional = false
        )

        editText.setNotationMaskWatcher(
                notation = romanNotation,
                mask = ROMAN_NUMERALS_PRIMARY_FORMAT
        )
        editText.hint = ROMAN_NUMERALS_CHARACTER_SET
    }

    private fun logValueListener(maskFilled: Boolean, extractedValue: String, formattedText: String) {
        val className = MainActivity::class.java.simpleName
        Log.d(className, extractedValue)
        Log.d(className, maskFilled.toString())
        Log.d(className, formattedText)
    }

}
