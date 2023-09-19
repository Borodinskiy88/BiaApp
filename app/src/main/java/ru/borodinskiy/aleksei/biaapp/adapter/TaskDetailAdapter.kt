package ru.borodinskiy.aleksei.biaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.borodinskiy.aleksei.biaapp.databinding.CardTaskDetailBinding
import ru.borodinskiy.aleksei.biaapp.entity.Task

class TaskDetailAdapter(
) :
    ListAdapter<Task, TaskDetailAdapter.TaskDetailViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskDetailViewHolder {

        return TaskDetailViewHolder(
            CardTaskDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        )
    }

    override fun onBindViewHolder(holder: TaskDetailViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class TaskDetailViewHolder(
        private val binding: CardTaskDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {

            binding.apply {

                cargoType.text = task.cargoType
                city.text = task.city
                date.text = task.date
                time.text = task.time
                startPoint.text = task.startPoint
                finishPoint.text = task.finishPoint
                bodyType.text = task.bodyType
                detail.text = task.detail
                paymentParam.text = task.paymentParam
                phoneNumber.text = task.telNumber
                name.text = task.name

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