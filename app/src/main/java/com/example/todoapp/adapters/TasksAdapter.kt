import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.TasksItemBinding
import com.example.todoapp.models.TasksModel

class TasksAdapter(var list: List<TasksModel>) : RecyclerView.Adapter<TasksAdapter.myViewHolder>() {

    inner class myViewHolder(val binding: TasksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            var isChecked  = binding.checkbox.isChecked
            if (isChecked){
                binding.taskName.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            }
            binding.checkbox.setOnCheckedChangeListener { compoundButton, b ->
                if (compoundButton.isChecked){
                    binding.taskName.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                }
                else{
                    binding.taskName.paintFlags = Paint.LINEAR_TEXT_FLAG
                }
            }
        }

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