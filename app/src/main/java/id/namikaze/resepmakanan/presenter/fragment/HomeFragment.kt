package id.namikaze.resepmakanan.presenter.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import id.namikaze.resepmakanan.data.Resource
import id.namikaze.resepmakanan.databinding.FragmentHomeBinding
import id.namikaze.resepmakanan.presenter.viewmodel.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.recipe.observe(viewLifecycleOwner, {
            when (it) {
               is Resource.Loading -> {
                   it.getLoadingStateIfNotHandled()?.let {

                   }
               }
                is Resource.Success -> {
                    it.getSuccessStateIfNotHandled()?.let {
                    }
                }
                is Resource.Error -> {
                    it.getErrorStateIfNotHandled()?.let {
                    }
                }
            }
        })

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getRecipesList()
        }
    }
}