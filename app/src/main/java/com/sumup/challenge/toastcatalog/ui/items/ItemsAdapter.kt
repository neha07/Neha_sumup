package com.sumup.challenge.toastcatalog.ui.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sumup.challenge.toastcatalog.data.model.Item
import com.sumup.challenge.toastcatalog.R
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private val items = mutableListOf<Item>()

    fun submitList(newItems: List<Item>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName = itemView.findViewById<TextView>(R.id.tv_item_name)
        private val itemPrice = itemView.findViewById<TextView>(R.id.tv_item_price)
        private val itemCircle = itemView.findViewById<TextView>(R.id.item_circle)
        private val lastSoldText = itemView.findViewById<TextView>(R.id.tv_last_sold)

        fun bind(item: Item) {
            itemName.text = item.name
            itemPrice.text = when {
                item.price.isNullOrBlank() -> "Price Unavailable"
                item.currency == "EUR" -> "${item.price} €"
                !item.currency.isNullOrBlank() -> "${item.price} ${item.currency}"
                else -> item.price
            }
            lastSoldText.text = formatLastSold(item.lastSold)
            setImage(item.id)
        }

        // TODO: add logic to set image (circle with item ID) for item
        private fun setImage(itemId: Int) {
            itemCircle.text = itemId.toString()
        }

        private fun formatLastSold(dateString: String?): String {
            return try {
                if (dateString.isNullOrBlank()) return "Last sold: Unknown"

                val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                inputFormat.timeZone = TimeZone.getTimeZone("UTC")
                val date = inputFormat.parse(dateString)

                val outputFormat = SimpleDateFormat("MM/dd/yy, h:mm a", Locale.getDefault())
                " ${outputFormat.format(date)} "
            } catch (e: Exception) {
                "Last sold: Unknown"
            }
        }
    }
}
