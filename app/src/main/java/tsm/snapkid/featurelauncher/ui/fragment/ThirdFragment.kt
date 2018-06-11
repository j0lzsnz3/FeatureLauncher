package tsm.snapkid.featurelauncher.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_third.*

import tsm.snapkid.featurelauncher.R
import tsm.snapkid.featurelauncher.ui.activity.AppsActivity
import tsm.snapkid.featurelauncher.utils.LauncherUtil

class ThirdFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val launcherUtil = LauncherUtil(activity)

        btn_setting.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.settings") }
        btn_calculator.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.calculator2") }

    }
}
