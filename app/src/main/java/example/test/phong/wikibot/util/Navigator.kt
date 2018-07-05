package example.test.phong.wikibot.util

import android.content.Context
import android.content.Intent
import example.test.phong.wikibot.ui.HomeActivity

object Navigator {
    fun openMain(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }
}