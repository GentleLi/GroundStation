package com.sunhawk.groundstation.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

class CircleView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        invalidate()
    }

}