package com.example.madlevel3task2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun databind(portal: Portal) {
            itemView.tvPortal.text = portal.portalName
            itemView.tvUrl.text = portal.url
            itemView.setOnClickListener {
                val url = Uri.parse(portal.url)
                val intent = Intent(Intent.ACTION_VIEW, url)
                val bundle = Bundle()
                bundle.putBoolean("new_window", true)
                intent.putExtras(bundle)
                var context: Context = itemView.context
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_portal, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return portals.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(portals[position])
    }


}