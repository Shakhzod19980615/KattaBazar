package com.example.kattabazar.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kattabazar.databinding.OfferItemBinding
import com.example.kattabazar.domain.model.OfferItemModel

class OfferItemAdapter(
    private val layoutInflater: LayoutInflater,
    //val onItemClick: (item : OfferItemModel) -> Unit
): RecyclerView.Adapter<OfferItemAdapter.ViewHolder>() {
    private  val offerListItem : MutableList<OfferItemModel> = mutableListOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): OfferItemAdapter.ViewHolder {
        val binding = OfferItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OfferItemAdapter.ViewHolder, position: Int) {
        holder.bindData(offerListItem = offerListItem[position])
    }

    override fun getItemCount(): Int {
        return offerListItem.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun setItems(offerListItem:List<OfferItemModel>){
        this.offerListItem.clear()
        this.offerListItem.addAll(offerListItem)
        notifyDataSetChanged()
    }
    inner class ViewHolder(
        private var binding : OfferItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bindData(offerListItem:OfferItemModel){
            binding.itemName.text = offerListItem.name
            binding.itemBrand.text = offerListItem.brand
            binding.itemAttrName.text = offerListItem.attributes[position].name
            binding.itemAttrValue.text = offerListItem.attributes[position].value
            Glide.with(binding.root).load(offerListItem.image).into(binding.itemImage)
        }
       /* init {
            itemView.setOnClickListener {
                val item = offerListItem[bindingAdapterPosition]
                onItemClick(item)
            }

        }*/
    }

}