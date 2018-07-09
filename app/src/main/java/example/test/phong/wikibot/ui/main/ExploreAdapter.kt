package example.test.phong.wikibot.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import example.test.phong.wikibot.R
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_CONTENT
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_CONTENT_OTHER
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_HEADER
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_VIEW_MORE
import java.util.*


class ExploreAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val mData: MutableList<ExploreModel> = ArrayList()

    companion object {
        val TYPE_HEADER = 0
        val TYPE_CONTENT = 1
        val TYPE_CONTENT_OTHER = 3
        val TYPE_VIEW_MORE = 4
    }

    init {
        // add content
        mData.add(ExploreHeader("Feature article", "Today, June 21"))
        mData.add(ExploreContent("North Carroll High School", "Iron City, Birmingham, AL", "Run the Jewels is an American hip hop duo, formed by rappers El-P and Killer Mike in 2013. That same year, they released their sel...",
                "http://www2.carrollk12.org/Assets/image/nch/media/nchs%20mediacenter1.jpg"))
        mData.add(ExploreHeader("Top read on Wikipedia", "Today, June 21"))
        mData.add(ExploreContentOther("Portrait of Maria Portinari", "Wood painting by Hans Memling.",
                "https://i.pinimg.com/564x/20/e0/b5/20e0b504ca48db1643502c18b76326ca.jpg"))
        mData.add(ExploreContentOther("Portrait of Maria Portinari", "Wood painting by Hans Memling.",
                "https://i.pinimg.com/564x/20/e0/b5/20e0b504ca48db1643502c18b76326ca.jpg"))
        mData.add(ExploreContentOther("Portrait of Maria Portinari", "Wood painting by Hans Memling.",
                "https://i.pinimg.com/564x/20/e0/b5/20e0b504ca48db1643502c18b76326ca.jpg"))
        mData.add(ExploreContentOther("Portrait of Maria Portinari", "Wood painting by Hans Memling.",
                "https://i.pinimg.com/564x/20/e0/b5/20e0b504ca48db1643502c18b76326ca.jpg"))
        mData.add(ExploreContentOther("Portrait of Maria Portinari", "Wood painting by Hans Memling.",
                "https://i.pinimg.com/564x/20/e0/b5/20e0b504ca48db1643502c18b76326ca.jpg"))
        mData.add(ExploreViewMore("All top read articles on June 21"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_header, parent, false)
                return ExploreHeaderVH(view)
            }
            TYPE_CONTENT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_content, parent, false)
                return ExploreContentVH(view)
            }
            TYPE_CONTENT_OTHER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_content_other, parent, false)
                return ExploreContentOtherVH(view)
            }
            TYPE_VIEW_MORE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_view_more, parent, false)
                return ExploreViewMoreVH(view)
            }
        }
        throw IllegalStateException("not have this type $viewType")
    }

    override fun getItemViewType(position: Int): Int {
        return mData.get(position).getType()
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

class ExploreViewMoreVH(view: View) : RecyclerView.ViewHolder(view) {

}

class ExploreContentOtherVH(view: View) : RecyclerView.ViewHolder(view) {

}

class ExploreContentVH(view: View) : RecyclerView.ViewHolder(view) {

}

class ExploreHeaderVH(view: View) : RecyclerView.ViewHolder(view) {

}

class ExploreViewMore(title: String) : ExploreModel {
    override fun getType(): Int {
        return TYPE_VIEW_MORE
    }
}

class ExploreContentOther(title: String, title2: String, thumb: String) : ExploreModel {
    override fun getType(): Int {
        return TYPE_CONTENT_OTHER
    }
}

class ExploreContent(title1: String, title2: String, title3: String, thumb: String) : ExploreModel {
    override fun getType(): Int {
        return TYPE_CONTENT
    }
}

class ExploreHeader(title1: String, subTitle1: String) : ExploreModel {
    override fun getType() = TYPE_HEADER
}

interface ExploreModel {
    fun getType(): Int
}
