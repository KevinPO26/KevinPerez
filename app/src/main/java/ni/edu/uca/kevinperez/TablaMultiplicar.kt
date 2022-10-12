package ni.edu.uca.kevinperez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.kevinperez.databinding.ActivityTablaMultiplicarBinding

class TablaMultiplicar : AppCompatActivity() {
    lateinit var binding: ActivityTablaMultiplicarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTablaMultiplicarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        iniciar()
    }

    private fun iniciar() {
        binding.btnTabla.setOnClickListener {
            obtenerTabla()
        }
        binding.btnLimpiarTabla.setOnClickListener{
            limpiar()
        }
    }

    private fun obtenerTabla() {
        try {
            val num = binding.etNumber.text.toString().toInt()
            var msn = ""
            var contador = 1
            while (contador <= 12) {
                msn += "${num} * ${contador} = ${num * contador} \n"
                contador += 1
            }
            binding.tvTabla.setText(msn)
        } catch (ex: Exception) {
            Toast.makeText(
                this@TablaMultiplicar, "Error: ${ex.toString()} ",
                Toast.LENGTH_LONG
            ).show()
        }
    }
    private fun limpiar(){
        with(binding){
            tvTabla.setText("")
            etNumber.setText("")
        }
    }
}