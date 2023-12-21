package uz.ilhomjon.viewpager2_14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.ilhomjon.viewpager2_14.adapters.MyViewPagerAdapter
import uz.ilhomjon.viewpager2_14.databinding.ActivityMainBinding
import uz.ilhomjon.viewpager2_14.models.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var list: ArrayList<User>
    lateinit var myViewPagerAdapter: MyViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()

        myViewPagerAdapter = MyViewPagerAdapter(list)
        binding.viewPager2.adapter = myViewPagerAdapter

    }

    private fun loadData() {
        list = ArrayList()
        list.add(User("Is gazi", "https://storage.kun.uz/source/thumbnails/_medium/10/ImVxxemRUG3d-cPWyzBrx-_34Pu6GetS_medium.jpg"))
        list.add(User("Aziz Vitov", "https://storage.kun.uz/source/10/HFHQyxO-RjoJ4hMbvNqwMQ9Q1eOouTvJ.jpg"))
        list.add(User("Hokim", "https://storage.kun.uz/source/10/nH2NN9TEDdw2KtBmer-L3PaFEiS_jm5m.jpg"))
    }
}