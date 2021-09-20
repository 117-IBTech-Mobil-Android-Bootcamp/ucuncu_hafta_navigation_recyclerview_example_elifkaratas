package com.example.week3.testresult
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.week3.BaseRecyclerViewItemClickListener
import com.example.week3.R
import com.example.week3.testresult.model.Data



class Adapter(private val dataList : List<Data>) : RecyclerView.Adapter<myViewHolder>() {

    private var itemClickListener: BaseRecyclerViewItemClickListener<Data> ?= null

    constructor(dataList : List<Data>, itemClickListener: BaseRecyclerViewItemClickListener<Data>) : this(dataList){
        this.itemClickListener = itemClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        return myViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.avatar_icon,parent,false))
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val data = this.dataList[position]
        holder.setData(data)
        holder.setOnItemClickListener(data, this.itemClickListener!!)
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }

    fun notifyChanges(clickedItem : Data){
        val clickedIndex = this.dataList.indexOf(clickedItem)
        notifyItemChanged(clickedIndex)
    }
}

class myViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    val checkBox = ItemView.findViewById<AppCompatImageView>(R.id.checkBox)
    val avatarIcon = ItemView.findViewById<ImageView>(R.id.avatarIcon)

    fun setData(data : Data) {
        avatarIcon.setImageResource(data.src_avatar_icon)
    }

    fun setOnItemClickListener(data : Data, itemClickListener: BaseRecyclerViewItemClickListener<Data>?) {
        checkBox.setOnClickListener {
            itemClickListener!!.onItemClicked(data, it.id)
        }
    }

}