package example.test.phong.wikibot.ui.main


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import example.test.phong.wikibot.R
import kotlinx.android.synthetic.main.fragment_explore.*

/**
 * A simple [Fragment] subclass.
 *
 */
class ExploreFragment : Fragment() {
    companion object {
        fun newInstance() = ExploreFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("tag", "density " + resources.displayMetrics.density)
        Log.e("tag", "density dpi" + resources.displayMetrics.densityDpi)
        rcv.adapter = ExploreAdapter(Glide.with(this))
        rcv.setHasFixedSize(true)
        rcv.layoutManager = LinearLayoutManager(context)
    }
}
