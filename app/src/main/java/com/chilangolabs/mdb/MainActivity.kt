package com.chilangolabs.mdb

import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val point = Point()
    var height = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.colorStatusBar)

        val display = windowManager.defaultDisplay
        display.getSize(point)
        height = point.y

//        val anim = AnimationUtils.loadAnimation(this, R.anim.jump_arrow)
//
//        imgLandingLeft.startAnimation(anim)
        imgLandingLeft.startAnimation(anim(100))
        imgLandingCenter.startAnimation(anim(200))
        imgLandingRight.startAnimation(anim(300))


    }


    fun anim(time: Long): TranslateAnimation {
        val tanim = TranslateAnimation(0f, 0f, height.toFloat() / 3, 0f)
        tanim.startOffset = time
        tanim.interpolator = BounceInterpolator()
        tanim.duration = 3000
        return tanim
    }

}
