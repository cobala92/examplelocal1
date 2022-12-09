package example.android.exam.examplelocal1.ui.myword

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import example.android.exam.examplelocal1.databinding.FragmentMywordBinding
import example.android.exam.examplelocal1.ui.base.BaseFragment

@AndroidEntryPoint
class MyWordFragment : BaseFragment<FragmentMywordBinding>(FragmentMywordBinding::inflate) {

    companion object {
        fun newInstance() = MyWordFragment()
    }

    private val viewModel: MyWordViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
        viewBinding
    }

}