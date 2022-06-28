package com.example.DicodingAndroid

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewMakananAdapter : RecyclerView.Adapter<CardViewMakananAdapter.CardViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
//        var materi: TextView = itemView.findViewById(R.id.tv_item_name)
//        var materiDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
    }

    class CardViewMakanan(private val listMakanan: ArrayList<Makanan>) : RecyclerView.Adapter<CardViewMakanan.CardViewViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
            val view: View =
                LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent, false)
            return CardViewViewHolder(view)
        }

        override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
            val detail = listMakanan[position]

            Glide.with(holder.itemView.context)
                .load(detail.photo)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgPhoto)

            holder.tvName.text = detail.name
            holder.tvDetail.text = detail.detail
            holder.itemView.setOnClickListener(View.OnClickListener {
                val activity = holder.itemView.context as Activity
                val dataView = Intent(activity, DetailView::class.java)
                dataView.putExtra(DetailView.photo, detail.photo)
                dataView.putExtra(DetailView.nama, detail.name)
                dataView.putExtra(DetailView.makanandetail, detail.detail)
                activity.startActivity(dataView)
            })

        }


        override fun getItemCount(): Int {
            return listMakanan.size
        }

        inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
            var tvName: TextView = itemView.findViewById(R.id.item_name)
            var tvDetail: TextView = itemView.findViewById(R.id.item_detail)
        }
    }
}