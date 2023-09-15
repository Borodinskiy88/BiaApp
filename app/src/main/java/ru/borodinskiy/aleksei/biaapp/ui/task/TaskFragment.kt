package ru.borodinskiy.aleksei.biaapp.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentTaskBinding
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentTaskDetailBinding

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)

        return binding.root
    }

}