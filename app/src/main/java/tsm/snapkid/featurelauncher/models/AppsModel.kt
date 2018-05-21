package tsm.snapkid.featurelauncher.models

import android.graphics.drawable.Drawable

class AppsModel (
        var appsIcon: Drawable? = null,
        var appsName: String? = null,
        var appsPackageName: String? = null,
        var appsVersionName: String? = null,
        var appsVersionCode: Int? = null)