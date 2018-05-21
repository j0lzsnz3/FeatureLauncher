package tsm.snapkid.featurelauncher.ui.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_second.*
import tsm.snapkid.featurelauncher.R
import tsm.snapkid.featurelauncher.utils.LauncherUtil

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val launcherUtil = LauncherUtil(activity)

        btn_whatsapp.setOnClickListener { launcherUtil.launchAppByPackageName("com.whatsapp") }
        btn_facebook.setOnClickListener { launcherUtil.launchAppByPackageName("com.facebook.lite") }
        btn_contact.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.contacts") }
        btn_browser.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.chrome") }
        btn_calculator.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.calculator2") }
        btn_message.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.mms") }
    }

}
