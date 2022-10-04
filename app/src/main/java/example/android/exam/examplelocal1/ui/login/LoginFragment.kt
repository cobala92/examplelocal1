package example.android.exam.examplelocal1.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import example.android.exam.examplelocal1.databinding.FragmentLoginBinding
import example.android.exam.examplelocal1.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
        viewBinding
    }
}