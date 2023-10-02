package com.example.jojo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)


        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPaper)

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)

        pagerAdapter.fragments.add(GropFragment())
        pagerAdapter.fragments.add(ChatFragment())
        pagerAdapter.fragments.add(StatusFragment())
        pagerAdapter.fragments.add(callFragment())


//        pagerAdapter.titles.add("Chart")
//        pagerAdapter.titles.add("Call")
//        pagerAdapter.titles.add(R.drawable.camera.toInt())

        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)


        tabLayout.getTabAt(0)?.setIcon(R.drawable.baseline_groups_24)
        tabLayout.getTabAt(1)?.setText("Chat")
        tabLayout.getTabAt(2)?.setText("Stutus")
        tabLayout.getTabAt(3)?.setText("Call")

    }

    class ViewPagerAdapter(fragmentManager: FragmentManager) :FragmentPagerAdapter(fragmentManager) {
        val fragments : MutableList<Fragment> = ArrayList()
//        val titles : MutableList<Any> = ArrayList()

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }


        override fun getPageTitle(position: Int): CharSequence? {
            when(position){
                0->return null
                1->return "Chat"
                2->return "Status"
                3->return "Call"

            }
            return super.getPageTitle(position)
        }

    }
}