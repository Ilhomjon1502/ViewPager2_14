package uz.ilhomjon.viewpager2_14.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.ilhomjon.viewpager2_14.fragments.ItemFragment
import uz.ilhomjon.viewpager2_14.models.User

class MyFragmentsAdapter(var list:ArrayList<User>, fm:FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ItemFragment.newInstance(list[position].name, list[position].imageLink)
    }
}