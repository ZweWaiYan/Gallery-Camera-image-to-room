package com.letuse.uploadimagetoroom.Image

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.letuse.uploadimagetoroom.R
import com.letuse.uploadimagetoroom.URIPathHelper
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>(){

    private var itemlist = emptyList<Image>()

    inner class ItemViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bind(image: Image){
            itemView.id_room.text = image.id.toString()
            Picasso.get().load(image.image).into(itemView.img_room)
            d("gg" , image.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemlist[position])
    }

    fun addCategoryList(item : List<Image>){
        this.itemlist = item
        notifyDataSetChanged()
    }
}