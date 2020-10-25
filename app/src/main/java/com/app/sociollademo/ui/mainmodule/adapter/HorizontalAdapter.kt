package com.app.sociollademo.ui.mainmodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.sociollademo.R
import com.app.sociollademo.model.api.horizontalmodel.HorizontalPhoto
import com.bumptech.glide.Glide


class HorizontalAdapter(
    val list: List<HorizontalPhoto>,
    var context: Context
) :
    RecyclerView.Adapter<HorizontalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HorizontalViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: HorizontalViewHolder, position: Int) {
        try {
            var item = list.get(position)
            holder.mTitleView?.setText("" + item.title)

            var imageUrl =
                "http://farm${item.farm}.staticflickr.com/${item.server}/${item.id}_${item.secret}.jpg"

            /*Picasso.with(context).load(imageUrl).fit().centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.img);
*/

            Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_shop_dummy_logo)
                .into(holder?.img!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }


    override fun getItemCount(): Int = 5

}

class HorizontalViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.horizontal_item_view, parent, false)) {
    var mTitleView: TextView? = null
    var img: ImageView? = null


    init {
        mTitleView = itemView.findViewById(R.id.txtTitle)
        img = itemView.findViewById(R.id.img)

    }


}
