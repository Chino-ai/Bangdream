package com.example.animelover.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animelover.core.databinding.ItemMemberBinding
import com.example.animelover.core.domain.model.Member
import java.util.ArrayList

class ListMemberAdapter : RecyclerView.Adapter<ListMemberAdapter.ListViewHolder>() {

    private var listData = ArrayList<Member>()
    var onItemClick: ((Member) -> Unit)? = null

    fun setData(newListData: List<Member>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_member, parent, false))

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemMemberBinding.bind(itemView)
        fun bind(data: Member) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(avatar)

                name.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}

