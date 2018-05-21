package tsm.snapkid.featurelauncher.utils

import android.content.Context
import android.widget.Toast

class LauncherUtil(private val context: Context?) {

    fun launchAppByPackageName(packageName: String?){
        try {
            context?.startActivity(context.packageManager?.getLaunchIntentForPackage(packageName))
        }catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(context, "Apps doesn't installed!", Toast.LENGTH_SHORT).show()
        }

    }
}