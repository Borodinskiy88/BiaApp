package ru.borodinskiy.aleksei.biaapp.ui.graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentGraphBinding

@AndroidEntryPoint
class GraphFragment : Fragment() {

    private lateinit var binding: FragmentGraphBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentGraphBinding.inflate(inflater, container, false)

        return binding.root
    }

}