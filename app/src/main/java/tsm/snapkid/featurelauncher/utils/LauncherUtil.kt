package tsm.snapkid.featurelauncher.utils

import android.content.Context
import android.widget.Toast
import tsm.snapkid.featurelauncher.R

class LauncherUtil(private val context: Context?) {

    fun launchAppByPackageName(packageName: String?){
        try {
            context?.startActivity(context.packageManager?.getLaunchIntentForPackage(packageName))
        }catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, context?.getString(R.string.str_fail_launch), Toast.LENGTH_SHORT).show()
        }

    }
}