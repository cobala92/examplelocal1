package example.android.exam.examplelocal1.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

data class TabMainItem(
    val fragment: Fragment,
    @DrawableRes val iconRes: Int?,
    @StringRes val titleRes: Int,
)
