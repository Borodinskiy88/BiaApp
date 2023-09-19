package ru.borodinskiy.aleksei.biaapp.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.util.copy
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.biaapp.adapter.TaskDetailAdapter
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentTaskDetailBinding
import ru.borodinskiy.aleksei.biaapp.entity.Task
import ru.borodinskiy.aleksei.biaapp.viewmodel.BiaViewModel

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {

    private lateinit var binding: FragmentTaskDetailBinding
    private val viewModel: BiaViewModel by activityViewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskDetailAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)

        val taskId = arguments?.getInt("taskId")

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = TaskDetailAdapter()
        recyclerView.adapter = adapter

        taskId?.let {
            viewModel.getTaskById(it).observe(viewLifecycleOwner) { task ->
                adapter.submitList(task)
            }
        }

        binding.apply {
            refuseButton.setOnClickListener {
                acceptButton.isVisible = false
                refuseButton.isVisible = false
            }
        }

        binding.apply {
            acceptButton.setOnClickListener {
                acceptButton.isVisible = false
                refuseButton.isVisible = false

                incidentButton.isVisible = true
                finishButton.isVisible = true
                taskRefuseButton.isVisible = true
            }
        }

        binding.finishButton.setOnClickListener {
            fun completeTask(task: Task) : Boolean {
                return task.complete
            }
        }

        binding.incidentButton.setOnClickListener {

        }

        binding.apply {
            taskRefuseButton.setOnClickListener {
                incidentButton.isVisible = false
                finishButton.isVisible = false
                taskRefuseButton.setOnClickListener {
                    return@setOnClickListener
                }
            }
        }

        return binding.root
    }

}