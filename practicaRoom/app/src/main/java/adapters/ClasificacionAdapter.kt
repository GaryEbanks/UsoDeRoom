package adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practicaroom.databinding.ItemClasificacionBinding
import model.entities.ClasificacionEntity

class ClasificacionAdapter(val clasificacionLista: List<ClasificacionEntity>): RecyclerView.Adapter<ClasificacionAdapter.ClasificacionHolder> (){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ClasificacionHolder {
        val binding = ItemClasificacionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ClasificacionHolder(binding)
    }

    override fun onBindViewHolder(holder: ClasificacionAdapter.ClasificacionHolder, position: Int) {
        holder.bind(clasificacionLista[position])
    }

    override fun getItemCount(): Int = clasificacionLista.size

    inner class ClasificacionHolder(val binding: ItemClasificacionBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(clasificacion: ClasificacionEntity){
            with(binding){
                TxtAbreviacion.text = clasificacion.abreviacion
                TxtId.text = clasificacion.idClasificacion.toString()
                TxtNombre.text = clasificacion.nombre
            }
        }
    }

}