package ir.mohadesehsayahi.NoteOnline.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ir.mohadesehsayahi.NoteOnline.R
import ir.mohadesehsayahi.NoteOnline.databinding.FragmentHomeBinding


class HomeFragment : Fragment(), AddNotePopupFragment.DialogNextBtnClickListener {


    private lateinit var auth : FirebaseAuth
    private lateinit var databaseRef: DatabaseReference
    private lateinit var navController: NavController
    private lateinit var binding: FragmentHomeBinding
    private lateinit var popupFragment: AddNotePopupFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)
        registreEvents()
    }

    private fun registreEvents() {
       binding.addBtnHome.setOnClickListener{
           popupFragment = AddNotePopupFragment()
           popupFragment.setListener(this)
           popupFragment.show(
               childFragmentManager,
               "AddNotePopupFragment",
           )
       }
    }

    private fun init(view: View) {
        navController =Navigation.findNavController(view)
        auth = FirebaseAuth.getInstance()
        databaseRef = FirebaseDatabase.getInstance().reference
    }

    override fun onSaveTask(todo: String, todoEt: TextInputEditText) {
        TODO("Not yet implemented")
    }
}