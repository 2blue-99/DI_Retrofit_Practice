package retrofit_DI.example.retrofit_practice.fragment

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit_DI.example.retrofit_practice.data.Data_Detail
import com.example.retrofit_practice.databinding.ItemBinding

/**
 * 2023-01-12
 * pureum
 */
class Adapter(): RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    var dataList = arrayListOf<Data_Detail>()
        set(value) {
            Log.e("TAG", ": 바뀜!!", )
            field = value
            notifyDataSetChanged()
        }

    inner class AdapterViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Data_Detail) {
            binding.textView.text = "${list.stdDate.slice(0..3)}.${list.stdDate.slice(4..5)}.${list.stdDate.slice(6..7)}"
            binding.textView2.text = "${list.stdHour.slice(0..1)}:${list.stdHour.slice(2..3)}"
            binding.textView3.text = "${list.conzoneName}"
            binding.textView4.text = "${list.speed}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}