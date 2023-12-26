package uz.ilhomjon.viewpager2_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.ilhomjon.viewpager2_14.adapters.MyFragmentsAdapter
import uz.ilhomjon.viewpager2_14.adapters.MyViewPagerAdapter
import uz.ilhomjon.viewpager2_14.databinding.ActivityMainBinding
import uz.ilhomjon.viewpager2_14.databinding.CustomTabViewBinding
import uz.ilhomjon.viewpager2_14.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()

        binding.viewPager2.adapter = MyFragmentsAdapter(list, supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.myTabLayout, binding.viewPager2) { tab, position ->

            val customTabViewBinding = CustomTabViewBinding.inflate(layoutInflater)

            if (position == 0){
                customTabViewBinding.tabIndicator.visibility = View.VISIBLE
            }else{
                customTabViewBinding.tabIndicator.visibility = View.GONE
            }

            customTabViewBinding.txtTitle.text = list[position].name

            tab.customView = customTabViewBinding.root
        }.attach()

        binding.myTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.view?.findViewById<LinearLayout>(R.id.tab_indicator)
                    ?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.view?.findViewById<LinearLayout>(R.id.tab_indicator)
                    ?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

    private fun loadData() {
        list = ArrayList()
        list.add(User("Is gazi", "https://storage.kun.uz/source/thumbnails/_medium/10/ImVxxemRUG3d-cPWyzBrx-_34Pu6GetS_medium.jpg"))
        list.add(User("Aziz Vitov", "https://storage.kun.uz/source/10/HFHQyxO-RjoJ4hMbvNqwMQ9Q1eOouTvJ.jpg"))
        list.add(User("Hokim", "https://storage.kun.uz/source/10/nH2NN9TEDdw2KtBmer-L3PaFEiS_jm5m.jpg"))
    }
}