import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TasksItemBinding
import com.example.todoapp.models.TasksModel

class TasksAdapter(var list: List<TasksModel>) : RecyclerView.Adapter<TasksAdapter.myViewHolder>() {
    inner class myViewHolder(val binding: TasksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(name: String, isDone: Boolean, time: Int) {
            binding.taskName.text = name
            binding.checkbox.isChecked = isDone
            binding.time.text = time.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val binding = TasksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val name = list[position].taskName
        val isDone = list[position].isDone
        val time = list[position].time
    }
}