package com.example.practicaroom

import adapters.ClasificacionAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaroom.databinding.FragmentViewClasificacionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.MainDataBase
import model.dao.ClasificacionDao

class ViewClasificacionFragment : Fragment() {
    lateinit var vBinding: FragmentViewClasificacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vBinding = FragmentViewClasificacionBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)
        val db: MainDataBase = MainDataBase.getInstance(this.requireContext().applicationContext)
        val dao: ClasificacionDao = db.clasificacionDao()

        CoroutineScope(Dispatchers.Main).launch {
            var listC = dao.getAll()

            vBinding.recyclerGenero.layoutManager = LinearLayoutManager(context)
            val adapter = ClasificacionAdapter(listC)
            vBinding.recyclerGenero.adapter = adapter
        }
    }


}