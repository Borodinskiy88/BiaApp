package ru.borodinskiy.aleksei.biaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.biaapp.databinding.CardTaskBinding
import ru.borodinskiy.aleksei.biaapp.ui.dto.Task

interface OnInteractionListener {
    fun onShowDetail(task: Task)
}

class TaskAdapter(
    private val onInteractionListener: OnInteractionListener
) :
    ListAdapter<Task, TaskAdapter.TaskViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {

        return TaskViewHolder(
            CardTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onInteractionListener
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class TaskViewHolder(
        private val binding: CardTaskBinding,
        private val onInteractionListener: OnInteractionListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {

            binding.apply {

                cargoType.text = task.cargoType
                currentTask.isVisible = task.currentTask == true
                date.text = task.date
                time.text = task.time
                startPoint.text = task.startPoint
                finishPoint.text = task.finishPoint
                detail.text = task.detail
                paymentParam.text = task.paymentParam

                showDetailButton.setOnClickListener {

                    onInteractionListener.onShowDetail(task)
                }
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Task>() {
            override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
                return oldItem == newItem
            }
        }
    }
}