package com.example.walmarttest.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmarttest.R
import com.example.walmarttest.databinding.ProductListFragmentLayoutBinding
import com.example.walmarttest.model.ProductItems
import com.example.walmarttest.model.UIState
import com.example.walmarttest.viewmodel.ProductsViewModel

private const val TAG = "ProductListFragment"

class ProductListFragment : Fragment() {

    private lateinit var binding: ProductListFragmentLayoutBinding
    private val viewModel: ProductsViewModel by lazy {
        ViewModelProvider(this)[ProductsViewModel::class.java]
    }
    private val adapter: ProductAdapter by lazy {
        ProductAdapter(emptyList())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = ProductListFragmentLayoutBinding.inflate(inflater, container, false)
        initViews()
        initObservables()
        return binding.root
    }
//niki.tran@walmart.com
    private fun initObservables() {
        viewModel.products.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.RESPONSE -> updateAdapter(it.products)
                is UIState.ERROR -> showError(it.errorResponse)
                is UIState.LOADING -> showLoading(it.isLoading)
            }
        }
    }

    private fun showLoading(loading: Boolean) {
        requireActivity().loadingController(loading)
    }

    private fun showError(errorResponse: String) {
        Log.d(TAG, "showError: $errorResponse")
        Toast.makeText(
            requireActivity(),
            errorResponse,
            Toast.LENGTH_LONG
        ).show()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    private fun updateAdapter(products: List<ProductItems>) {
        Log.d(TAG, "updateAdapter: $products")
        adapter.updateDataSet(products)
    }

    private fun initViews() {
        binding.productList.adapter = adapter
        binding.productList.layoutManager = LinearLayoutManager(context)
    }

    private fun FragmentActivity.loadingController(isLoading: Boolean){
        if (isLoading)
            findViewById<ProgressBar>(R.id.loading).visibility = View.VISIBLE
        else
            findViewById<ProgressBar>(R.id.loading).visibility = View.GONE
    }
}