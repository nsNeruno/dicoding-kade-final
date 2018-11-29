package dev.neruno.lab.footballapps.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter<T, B>(
    private val items: List<T>,
    private val layout: Int,
    private val onBindItem: (B, T) -> Unit,
    private val onItemClick: (T) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter<T, B>.ViewHolder<B>>()
        where B : ViewDataBinding {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<B> {
        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder<B>, position: Int) {
        val item = items[position]
        val binding = holder.getBinding()
        onBindItem(binding, item)
        holder.setOnItemClickListener(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder<B>(private val binding: B) : RecyclerView.ViewHolder(binding.root) where B : ViewDataBinding {

        fun getBinding(): B {
            return binding
        }

        fun setOnItemClickListener(item: T) {
            binding.root.setOnClickListener { onItemClick(item) }
        }
    }
}