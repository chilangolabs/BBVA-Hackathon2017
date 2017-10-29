package com.chilangolabs.mdb.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

/**
 * @author Gorro.
 */
class MDBTextView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : TextView(context, attrs, defStyleAttr) {
    init {
        MDBFontManager(context).initStyle(this, attrs)
    }
}