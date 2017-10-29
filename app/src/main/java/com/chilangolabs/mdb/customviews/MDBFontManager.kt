package com.chilangolabs.mdb.customviews

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.chilangolabs.mdb.R

/**
 * @author Gorro.
 */

class MDBFontManager(private val context: Context?) {

    /**
     * Init custom font to view
     * @param view you want asing font
     * @param attrs attributeset with value of font can be null
     */
    fun initStyle(view: View, attrs: AttributeSet? = null) {
        if (attrs != null) {
            val typedArray = context?.theme?.obtainStyledAttributes(attrs, R.styleable.fontraleway, 0, 0)
            val tp = when (typedArray?.getInteger(R.styleable.fontraleway_type, 0)) {
                0 -> Typeface.createFromAsset(context?.assets, "fonts/Raleway-Light.ttf")
                1 -> Typeface.createFromAsset(context?.assets, "fonts/Raleway-Medium.ttf")
                2 -> Typeface.createFromAsset(context?.assets, "fonts/Raleway-Regular.ttf")
                3 -> Typeface.createFromAsset(context?.assets, "fonts/Raleway-SemiBold.ttf")
                else -> {
                    Typeface.createFromAsset(context?.assets, "fonts/Raleway-Regular.ttf")
                }
            }
            typedArray?.recycle()
            setTypeFace(view, tp)
        } else {
            setTypeFace(view)
        }


    }

    /**
     * This function asing typeface to view
     * @param view view you want asing the typeface font
     * @param tp this is the typeface can be null
     */
    fun setTypeFace(view: View, tp: Typeface = Typeface.createFromAsset(context?.assets, "fonts/Raleway-Regular.ttf")) {
        when (view) {
            is TextView -> view.typeface = tp
            is EditText -> view.typeface = tp
            is Button -> view.typeface = tp
        }
    }
}