package tsm.snapkid.featurelauncher.ui.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

import tsm.snapkid.featurelauncher.R
import tsm.snapkid.featurelauncher.ui.activity.AppsActivity
import tsm.snapkid.featurelauncher.utils.LauncherUtil

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val launcherUtil = LauncherUtil(activity)

        image_song_played.bringToFront()

        btn_spotify.setOnClickListener { launcherUtil.launchAppByPackageName("com.spotify.music") }
        btn_apps.setOnClickListener { startActivity(Intent(activity, AppsActivity::class.java)) }
        btn_melon.setOnClickListener { launcherUtil.launchAppByPackageName("com.melon.http") }
        btn_phone.setOnClickListener { launcherUtil.launchAppByPackageName("com.android.dialer") }
    }
}
