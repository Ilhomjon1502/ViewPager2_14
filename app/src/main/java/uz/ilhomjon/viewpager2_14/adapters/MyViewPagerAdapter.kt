package uz.ilhomjon.viewpager2_14.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso
import uz.ilhomjon.viewpager2_14.databinding.ItemViewPagerBinding
import uz.ilhomjon.viewpager2_14.models.User

class MyViewPagerAdapter(val list:ArrayList<User>) : RecyclerView.Adapter<MyViewPagerAdapter.Vh>() {

    inner class Vh(var itemViewPagerBinding: ItemViewPagerBinding):ViewHolder(itemViewPagerBinding.root){
        fun onBind(user: User){
            itemViewPagerBinding.tvItem.text = user.name
            Picasso.get().load(user.imageLink).into(itemViewPagerBinding.imageItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }
}