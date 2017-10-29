package com.chilangolabs.mdb.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.Button

/**
 * @author Gorro.
 */
class MDBButton @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : Button(context, attrs, defStyleAttr) {
    init {
        MDBFontManager(context).initStyle(this, attrs)
    }
}