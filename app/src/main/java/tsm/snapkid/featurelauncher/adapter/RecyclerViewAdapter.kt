package tsm.snapkid.featurelauncher.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import tsm.snapkid.featurelauncher.R
import tsm.snapkid.featurelauncher.models.AppsModel
import tsm.snapkid.featurelauncher.utils.LauncherUtil

class RecyclerViewAdapter(private val context: Context, private val listApps: List<AppsModel>?) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_apps_layout, parent, false))

    override fun getItemCount(): Int = listApps?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launcherUtil = LauncherUtil(context)

        val appsName = listApps?.get(position)?.appsName
        val appsPackageName = listApps?.get(position)?.appsPackageName
        val appsIcon = listApps?.get(position)?.appsIcon

        holder.appsImageView.setImageDrawable(appsIcon)
        holder.appsName.text = appsName

        holder.btnLaunch.setOnClickListener { launcherUtil.launchAppByPackageName(appsPackageName) }

        val packageUri: Uri = Uri.parse("package:$appsPackageName")
        holder.btnUninstall.setOnClickListener { context.startActivity(Intent(Intent.ACTION_UNINSTALL_PACKAGE, packageUri)) }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val appsImageView: CircleImageView = itemView.findViewById(R.id.image_apps)
        val appsName: TextView = itemView.findViewById(R.id.tv_apps_name)
        val btnLaunch: Button = itemView.findViewById(R.id.btn_launch)
        val btnUninstall: Button = itemView.findViewById(R.id.btn_uninstall)
    }
}