package ru.borodinskiy.aleksei.biaapp.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.borodinskiy.aleksei.biaapp.R
import ru.borodinskiy.aleksei.biaapp.databinding.FragmentTaskIncidentBinding

@AndroidEntryPoint
class TaskIncidentFragment : Fragment() {

    private lateinit var binding: FragmentTaskIncidentBinding
    private var textValue = String()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskIncidentBinding.inflate(inflater, container, false)

        val taskId = arguments?.getInt("taskId")

        binding.apply {
                radioGroup.setOnCheckedChangeListener { _, checkedId ->
                    when(checkedId) {
                        R.id.radio_button_address -> {
                            textValue = "Проблема на адресе"
                            textIncident.text = textValue
                        }
                        R.id.radio_button_path -> {
                            textValue = "Проблема в пути"
                            textIncident.text = textValue
                        }
                        R.id.radio_button_load -> {
                            textValue = "Проблема на загрузке"
                            textIncident.text = textValue
                        }
                    }
                }
            saveButton.setOnClickListener {
                if (textValue.isBlank()) {
                    Toast.makeText(requireContext(), "Выберите один из вариантов", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                } else {
                    val bundle = bundleOf(
                        Pair("incident", textValue),
                        Pair("taskId", taskId)
                    )
                    findNavController().navigate(R.id.action_taskIncidentFragment_to_taskDetailFragment, bundle)
                }

            }

        }

        return binding.root
    }
}