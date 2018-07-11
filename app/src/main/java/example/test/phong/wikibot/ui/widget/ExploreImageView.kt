package example.test.phong.wikibot.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class ExploreImageView(context: Context?, attrs: AttributeSet?): ImageView(context, attrs) {
    private val RESPECT = 1 / 2f

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val w = MeasureSpec.getSize(widthMeasureSpec)
        setMeasuredDimension(w, (w * RESPECT).toInt())
    }
}