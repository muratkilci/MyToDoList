package com.example.mytodolist.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytodolist.R
import com.example.mytodolist.databinding.FragmentTasksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment : Fragment(R.layout.fragment_tasks) {
    private val viewModel: TasksViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding= FragmentTasksBinding.bind(view)

        val tasksAdapter = TasksAdapter()

        binding.apply {
            recyclerViewTasks.apply {
                adapter = tasksAdapter
                layoutManager=LinearLayoutManager(requireContext())
                setHasFixedSize(true)                    // to make the recyclerView fixed size(ekran çevirme)

            }
        }
        viewModel.tasks.observe(viewLifecycleOwner){
            tasksAdapter.submitList(it)
        }
    }
}