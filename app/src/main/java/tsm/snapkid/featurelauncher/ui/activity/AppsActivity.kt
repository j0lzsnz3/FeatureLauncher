package tsm.snapkid.featurelauncher.ui.activity

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_apps.*
import tsm.snapkid.featurelauncher.R
import tsm.snapkid.featurelauncher.adapter.RecyclerViewAdapter
import tsm.snapkid.featurelauncher.models.AppsModel
import java.util.*


class AppsActivity : AppCompatActivity() {

    private var listApps: List<AppsModel>? = null
    private var recyclerAdapter: RecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apps)

        getInstalledApps()

        setupRecyclerView()
    }

    private fun getInstalledApps() {
        val res = ArrayList<AppsModel>()
        val packs = packageManager.getInstalledPackages(0)
        for (i in packs.indices) {
            val p = packs[i]
            var appName: String

            appName = if (!isSystemPackage(p)) {
                p.applicationInfo.loadLabel(packageManager).toString()
            }else {
                p.applicationInfo.loadLabel(packageManager).toString() + " (System)"
            }

            val icon = p.applicationInfo.loadIcon(packageManager)
            val appsPackageName = p.applicationInfo.packageName

            res.add(AppsModel(icon, appName, appsPackageName))
        }

        res.sortBy { it.appsName }
        listApps = res

        Log.d("AppsActivity", "result ${listApps?.get(0)?.appsName}")
    }

    private fun isSystemPackage(pkgInfo: PackageInfo): Boolean = pkgInfo.applicationInfo.flags and ApplicationInfo.FLAG_SYSTEM != 0

    private fun setupRecyclerView(){
        recyclerAdapter = RecyclerViewAdapter(this, listApps)

        listAppsRecyclerView.layoutManager = LinearLayoutManager(this)
        listAppsRecyclerView.setHasFixedSize(true)
        listAppsRecyclerView.adapter = recyclerAdapter
    }

    override fun onResume() {
        super.onResume()
        getInstalledApps()
        setupRecyclerView()
        recyclerAdapter?.notifyDataSetChanged()
    }
}
