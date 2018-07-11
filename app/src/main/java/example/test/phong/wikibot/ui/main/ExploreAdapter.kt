package example.test.phong.wikibot.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import example.test.phong.wikibot.R
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_CONTENT
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_CONTENT_OTHER
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_HEADER
import example.test.phong.wikibot.ui.main.ExploreAdapter.Companion.TYPE_VIEW_MORE
import kotlinx.android.synthetic.main.item_explore_content.view.*
import kotlinx.android.synthetic.main.item_explore_content_other.view.*
import kotlinx.android.synthetic.main.item_explore_header.view.*
import kotlinx.android.synthetic.main.item_explore_view_more.view.*
import java.util.*


class ExploreAdapter(private val requestManager: RequestManager) : RecyclerView.Adapter<ExploreVH>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreVH {
        when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_header, parent, false)
                return ExploreHeaderVH(view)
            }
            TYPE_CONTENT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_content, parent, false)
                return ExploreContentVH(view, requestManager)
            }
            TYPE_CONTENT_OTHER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_explore_content_other, parent, false)
                return ExploreContentOtherVH(view, requestManager)
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

    override fun onBindViewHolder(holder: ExploreVH, position: Int) {
        val model = mData.get(position)
        holder.bind(model)
    }

}

class ExploreViewMoreVH(view: View) : ExploreVH(view) {
    override fun bind(model: ExploreModel) {
        if (model is ExploreViewMore) {
            itemView.textView5.text = model.title
        }
    }

}

class ExploreContentOtherVH(view: View, val requestManager: RequestManager) : ExploreVH(view) {
    override fun bind(model: ExploreModel) {
        if (model is ExploreContentOther) {
            requestManager.load(model.thumb).into(itemView.imageView5)
            itemView.tv1.text = model.title
            itemView.tv2.text = model.title2
        }
    }

}

class ExploreContentVH(view: View, val requestManager: RequestManager) : ExploreVH(view) {
    override fun bind(model: ExploreModel) {
        if (model is ExploreContent) {
            requestManager.load(model.thumb).into(itemView.imageView_content)
            itemView.textView_over_image.text = model.title1
            itemView.textView1.text = model.title2
            itemView.textView2.text = model.title3
        }
    }
}

class ExploreHeaderVH(view: View) : ExploreVH(view) {
    override fun bind(model: ExploreModel) {
        if (model is ExploreHeader) {
            itemView.textView3.text = model.title1
            itemView.textView4.text = model.subTitle1
        }
    }

}

abstract class ExploreVH(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(model: ExploreModel)
}

class ExploreViewMore(val title: String) : ExploreModel {
    override fun getType(): Int {
        return TYPE_VIEW_MORE
    }
}

class ExploreContentOther(val title: String, val title2: String, val thumb: String) : ExploreModel {
    override fun getType(): Int {
        return TYPE_CONTENT_OTHER
    }
}

class ExploreContent(val title1: String, val title2: String, val title3: String, val thumb: String) : ExploreModel {
    override fun getType(): Int {
        return TYPE_CONTENT
    }
}

class ExploreHeader(val title1: String, val subTitle1: String) : ExploreModel {
    override fun getType() = TYPE_HEADER
}

interface ExploreModel {
    fun getType(): Int
}
