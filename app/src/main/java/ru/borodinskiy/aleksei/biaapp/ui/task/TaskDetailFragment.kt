package ru.borodinskiy.aleksei.biaapp.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.biaapp.R
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentTaskDetailBinding

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {

    private lateinit var binding: FragmentTaskDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

}