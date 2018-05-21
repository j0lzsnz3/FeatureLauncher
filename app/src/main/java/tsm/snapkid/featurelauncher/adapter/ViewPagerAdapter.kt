package tsm.snapkid.featurelauncher.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import tsm.snapkid.featurelauncher.ui.fragment.MainFragment
import tsm.snapkid.featurelauncher.ui.fragment.SecondFragment
import tsm.snapkid.featurelauncher.ui.fragment.ThirdFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MainFragment()
            1 -> fragment = SecondFragment()
            2 -> fragment = ThirdFragment()
        }

        return fragment
    }

    override fun getCount(): Int {
        return 3
    }
}