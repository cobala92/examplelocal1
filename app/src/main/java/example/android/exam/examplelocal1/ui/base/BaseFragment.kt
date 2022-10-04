package example.android.exam.examplelocal1.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
  private val inflateViewBinding: ((LayoutInflater, ViewGroup?, Boolean) -> VB)?,
) : Fragment() {
  private var _viewBinding: VB? = null

  protected val viewBinding: VB
    get() = checkNotNull(_viewBinding) {
      "Cannot access viewBinding after onDestroyView(), " +
        "or this Fragment ($this) doesn't use viewBinding"
    }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val inflate = inflateViewBinding ?: return null
    return inflate(inflater, container, false)
      .also { _viewBinding = it }
      .root
  }

  override fun onDestroyView() {
    _viewBinding = null
    super.onDestroyView()
  }
}
