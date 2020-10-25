package com.app.sociollademo.ui.mainmodule.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.sociollademo.R
import com.app.sociollademo.model.api.horizontalmodel.HorizontalPhoto
import com.app.sociollademo.model.api.verticalmodel.Photo
import com.app.sociollademo.utils.SessionManger
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class VerticalAdapter(
    val list: List<Photo>,
    var context: Context,
   var  horizontalList: List<HorizontalPhoto>
) :
    RecyclerView.Adapter<VerticalViewHolder>() {
    var mAdapter: HorizontalAdapter? = null
    var mLayoutManager: RecyclerView.LayoutManager? = null

    var sessionManger: SessionManger? = null
    var imageArrayList = ArrayList<HorizontalPhoto>()
    var newImageArrayList = ArrayList<HorizontalPhoto>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return VerticalViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: VerticalViewHolder, position: Int) {
        if (position % 3 == 0 && position != 0) {
            sessionManger = SessionManger(context, SessionManger.PREF_FILE_NAME)

            holder.layoutMediaItem!!.visibility = View.GONE
            holder.recyclerView!!.visibility = View.VISIBLE
            imageArrayList = ArrayList<HorizontalPhoto>()
            imageArrayList.addAll(horizontalList)

            newImageArrayList.clear()

            if (position == 3) {

                for (i in 0..4) {
                    newImageArrayList.add(imageArrayList.get(i))
                }
                sessionManger!!.setUserID(5)

            } else {
                var lastPosition = sessionManger!!.getUserID()
                var newposition = sessionManger!!.getUserID() + 5
                if (newposition <= imageArrayList.size - 1) {
                    for (i in lastPosition..newposition) {
                        newImageArrayList.add(imageArrayList.get(i))
                    }
                    sessionManger?.setUserID(newposition)
                } else {
                    newImageArrayList = imageArrayList
                }
            }
            mAdapter = HorizontalAdapter(newImageArrayList, context)
            mLayoutManager =
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            holder.recyclerView!!.setLayoutManager(mLayoutManager)
            holder.recyclerView!!.setItemAnimator(DefaultItemAnimator())
            holder.recyclerView!!.setAdapter(mAdapter)
        } else {
            var item = list.get(position)
            holder.layoutMediaItem!!.visibility = View.VISIBLE
            holder.recyclerView!!.visibility = View.GONE
            holder.mTitleView?.setText("" + item.title)

            var imageUrl =
                "http://farm${item.farm}.staticflickr.com/${item.server}/${item.id}_${item.secret}.jpg"

            Log.e("iamgePath",imageUrl)

          /*  Picasso.with(context).load(imageUrl).fit().centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.img);*/


            Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.ic_shop_dummy_logo)
                .into(holder?.img!!)

        }

    }

    override fun getItemCount(): Int = list.size
}

class VerticalViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.main_adapter_item_view, parent, false)) {
    var mTitleView: TextView? = null
    var img: ImageView? = null
    var recyclerView: RecyclerView? = null
    var layoutMediaItem: CardView? = null


    init {
        mTitleView = itemView.findViewById(R.id.txtTitle)
        img = itemView.findViewById(R.id.img)
        recyclerView = itemView.findViewById(R.id.recyclerview)
        layoutMediaItem = itemView.findViewById<CardView>(R.id.cardview)
    }


}
