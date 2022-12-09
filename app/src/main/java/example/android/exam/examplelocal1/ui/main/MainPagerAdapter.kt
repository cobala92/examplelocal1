package example.android.exam.examplelocal1.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import example.android.exam.examplelocal1.data.model.TabMainItem

class MainPagerAdapter(fm: FragmentManager, private val itemTabs: List<TabMainItem>) :
    FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = itemTabs.size

    override fun getPageTitle(position: Int): CharSequence {
        return itemTabs[position].titleRes
    }

    override fun getItem(position: Int): Fragment {
        return itemTabs[position].fragment
    }
}