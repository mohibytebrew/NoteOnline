package ir.mohadesehsayahi.NoteOnline.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.android.material.textfield.TextInputEditText
import ir.mohadesehsayahi.NoteOnline.R
import ir.mohadesehsayahi.NoteOnline.databinding.FragmentAddNotePopupBinding
import ir.mohadesehsayahi.NoteOnline.databinding.FragmentSignInBinding

class AddNotePopupFragment : DialogFragment() {

    private lateinit var binding: FragmentAddNotePopupBinding
    private lateinit var listener : DialogNextBtnClickListener

    fun setListener(listener: DialogNextBtnClickListener){
        this.listener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddNotePopupBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    registerEvents()
    }
    private fun registerEvents(){
        binding.todoNextBtn.setOnClickListener{
            val NoteTask = binding.todoEt.text.toString()
            if(NoteTask.isNotEmpty()){
                listener.onSaveTask(NoteTask, binding.todoEt)
            }else{
                Toast.makeText(context, "your note is Empty :(", Toast.LENGTH_SHORT).show()
            }
        }
    }
    interface  DialogNextBtnClickListener{
        fun onSaveTask(todo: String, todoEt : TextInputEditText)
    }

}