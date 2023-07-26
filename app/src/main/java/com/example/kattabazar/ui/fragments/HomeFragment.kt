package com.example.kattabazar.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kattabazar.R
import com.example.kattabazar.databinding.FragmentHomeBinding
import com.example.kattabazar.di.AppComponent
import com.example.kattabazar.ui.adapters.OfferItemAdapter
import com.example.kattabazar.ui.viewmodels.OfferViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class HomeFragment : Fragment(R.layout.fragment_home) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentHomeBinding by Delegates.notNull()
    private  var viewModel : OfferViewModel by Delegates.notNull()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,viewModelFactory)[OfferViewModel::class.java]
        val offerRV =view.findViewById<RecyclerView>(R.id.offer_rv)
        offerRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),LinearLayoutManager.VERTICAL, false
            )
        }
        val offerAdapter = OfferItemAdapter(layoutInflater)
        offerRV.adapter = offerAdapter
        viewModel.getOfferList()
        viewModel.offerListLiveData.observe(viewLifecycleOwner){
            offerAdapter.setItems(it.offersListModel)
        }
    }

}