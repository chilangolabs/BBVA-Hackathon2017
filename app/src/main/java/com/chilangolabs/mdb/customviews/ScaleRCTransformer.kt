package com.chilangolabs.mdb.customviews

import android.view.View
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager


/**
 * @author Gorro.
 */
class ScaleRCTransformer : GalleryLayoutManager.ItemTransformer {

    override fun transformItem(layoutManager: GalleryLayoutManager, item: View, fraction: Float) {
        item.pivotX = item.width / 2f
        item.pivotY = item.height / 2.0f
        val scale = 1 - 0.3f * Math.abs(fraction)
        item.scaleX = scale
        item.scaleY = scale
    }
}