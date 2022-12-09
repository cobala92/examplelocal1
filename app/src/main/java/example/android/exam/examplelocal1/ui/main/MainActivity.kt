package example.android.exam.examplelocal1.ui.main

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint
import example.android.exam.examplelocal1.R
import example.android.exam.examplelocal1.ui.extension.collectIn
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel.uiState.collectIn(this) { uiState ->
            Timber.tag("XXX").d("User Id = ${uiState.userUi?.id}")
        }
        initViewPager()
    }

    private fun initViewPager() {
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager>(R.id.pager)
        viewPager.adapter = MainPagerAdapter(
            supportFragmentManager, mainViewModel.getTabMainItems()
        )
        tabLayout.setupWithViewPager(viewPager)
        mainViewModel.getTabMainItems().forEachIndexed { index, tabMainItem ->
            val rootViewTab = View.inflate(this, R.layout.view_custom_tab, null)
            val title = rootViewTab.findViewById<TextView>(R.id.tvTab)
            val image = rootViewTab.findViewById<ImageView>(R.id.imgTab)
            val tab = tabLayout.getTabAt(index)
            title.text = tabMainItem.titleRes
            image.setImageResource(tabMainItem.iconRes)
            tab?.customView = rootViewTab
        }
    }

}