package ru.borodinskiy.aleksei.biaapp.ui.task

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.biaapp.R
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

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)

        val taskId = arguments?.getInt("taskId")
        val incident = arguments?.getString("incident")

        binding.apply {
            if (incident != null) {
                incidentButton.text = incident
                incidentButton.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.red_200
                    )
                )
                acceptButton.isVisible = false
                refuseButton.isVisible = false
                incidentButton.isVisible = true
                finishButton.isVisible = true
                taskRefuseButton.isVisible = true

            }
        }

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
            //TODO
            fun completeTask(task: Task): Boolean {
                return task.complete
            }
        }

        binding.incidentButton.setOnClickListener {
            val bundle = bundleOf(
                Pair("taskId", taskId)
            )
            findNavController().navigate(
                R.id.action_taskDetailFragment_to_taskIncidentFragment,
                bundle
            )
        }

        binding.apply {
            taskRefuseButton.setOnClickListener {
                incidentButton.isVisible = false
                finishButton.isVisible = false
                taskRefuseButton.text = "Вы отказались от задания"
            }
        }

        return binding.root
    }

}