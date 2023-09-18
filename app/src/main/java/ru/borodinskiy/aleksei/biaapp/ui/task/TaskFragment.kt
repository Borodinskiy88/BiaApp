package ru.borodinskiy.aleksei.biaapp.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.biaapp.adapter.OnInteractionListener
import ru.borodinskiy.aleksei.biaapp.adapter.TaskAdapter
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentTaskBinding
import ru.borodinskiy.aleksei.biaapp.entity.Task
import ru.borodinskiy.aleksei.biaapp.viewmodel.BiaViewModel
import kotlin.coroutines.suspendCoroutine

@AndroidEntryPoint
class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private val viewModel: BiaViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = TaskAdapter(object : OnInteractionListener {
            override fun onShowDetail(task: Task) {
                //TODO
                return
            }

        })

//        viewModel.insertAll()

        recyclerView.adapter = adapter

        viewModel.allTask.observe(viewLifecycleOwner) {

            adapter.submitList(it)
        }


        return binding.root
    }

}