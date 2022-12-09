package example.android.exam.examplelocal1.data.model

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment

data class TabMainItem(
    val fragment: Fragment,
    @DrawableRes val iconRes: Int,
    val titleRes: String,
)
