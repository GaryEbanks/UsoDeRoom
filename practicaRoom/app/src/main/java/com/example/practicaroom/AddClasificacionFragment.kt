package com.example.practicaroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.practicaroom.databinding.FragmentAddClasificacionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.MainDataBase
import model.dao.ClasificacionDao
import model.entities.ClasificacionEntity

class AddClasificacionFragment : Fragment() {
    private lateinit var aBinding: FragmentAddClasificacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        aBinding = FragmentAddClasificacionBinding.inflate(inflater, container, false)
        return aBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: MainDataBase = MainDataBase.getInstance(this.requireContext().applicationContext)
        val dao: ClasificacionDao = db.clasificacionDao()

        with(aBinding){
            btnAgregar.setOnClickListener {
                val new = ClasificacionEntity (0,etAbreviacion.text.toString(),etNombre.text.toString(), true)

                CoroutineScope(Dispatchers.Main).launch {
                    dao.insert(new)
                }
                navController.navigate(R.id.menuFragment)
            }
        }
    }
}