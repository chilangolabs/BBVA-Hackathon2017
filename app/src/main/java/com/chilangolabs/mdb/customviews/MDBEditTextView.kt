package com.chilangolabs.mdb.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText

/**
 * @author Gorro.
 */
class MDBEditTextView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : EditText(context, attrs, defStyleAttr) {
    init {
        MDBFontManager(context).initStyle(this, attrs)
    }
}