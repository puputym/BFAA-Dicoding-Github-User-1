package com.dicoding.picodipolma.githubusers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GithubAdapter(val listUser: ArrayList<GithubModel>): RecyclerView.Adapter<GithubAdapter.GithubViewHolder>() {
    private lateinit var onItemClickCallback : OnItemClickCallback
    private lateinit var searchView: SearchView
    var row_index: Int  = -1
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: GithubModel)

    }
    inner class GithubViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_name)
        var tvUsername : TextView = itemView.findViewById(R.id.tv_username)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_user)
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_user, parent, false)
        return GithubViewHolder(view)
    }

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        val produk = listUser[position]
        Glide.with(holder.itemView.context)
            .load(produk.avatar)
            .apply(RequestOptions().override(120, 120))
            .into(holder.imgPhoto)
        holder.tvName.text = produk.name
        holder.tvUsername.text = produk.username
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listUser[holder.adapterPosition])
            row_index = position
            notifyDataSetChanged()

        }
        if (row_index == position){
            holder.itemView.setBackgroundResource(R.drawable.bg_rv)
        }else{
            holder.itemView.setBackgroundResource(R.drawable.bg_search)
        }

    }

    override fun getItemCount(): Int = listUser.size


}