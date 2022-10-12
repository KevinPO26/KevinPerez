package ni.edu.uca.kevinperez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.kevinperez.databinding.ActivityMediaAritmeticaBinding

class MediaAritmetica : AppCompatActivity() {
    lateinit var binding: ActivityMediaAritmeticaBinding
    val numbers: MutableList<Int> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMediaAritmeticaBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        iniciar()
    }

    private fun iniciar() {
        binding.btnAgregar.setOnClickListener {
            agregar()
        }
        binding.btnMediaA.setOnClickListener {
            calcularMediaAritmetica()
        }
        binding.btnEliminar.setOnClickListener {
            limpiarLista()
        }
    }

    private fun agregar() {
        val number = binding.etNumero.text.toString().toInt()
        println(number)
        numbers.add(number)
        limpiar()
    }

    private fun limpiar() {
        with(binding) {
            etNumero.setText("")
        }
    }

    private fun calcularMediaAritmetica() {
        try {
            val sum: Double = numbers.sum().toDouble() / numbers.size
            val result = "${sum}"
            binding.tvMediaA.setText(result)
        } catch (ex: Exception) {
            Toast.makeText(
                this@MediaAritmetica, "Error: ${ex.toString()} ",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun limpiarLista() {
        try {
            numbers.removeAll(numbers)
            binding.tvMediaA.setText("")
            limpiar()
        } catch (ex: Exception) {
            Toast.makeText(
                this@MediaAritmetica, "Error: ${ex.toString()} ",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}