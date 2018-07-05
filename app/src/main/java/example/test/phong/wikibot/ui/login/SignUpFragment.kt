package example.test.phong.wikibot.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import example.test.phong.wikibot.R
import example.test.phong.wikibot.ui.main.MainViewModel
import example.test.phong.wikibot.util.Navigator
import kotlinx.android.synthetic.main.sign_up_fragment.*

class SignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.sign_up_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        button_signup.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_signUpFragment_to_loginFragment, null))
        button_login.setOnClickListener {
            Navigator.openMain(context!!)
        }
    }

}
