package ni.edu.uca.kevinperez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import ni.edu.uca.kevinperez.databinding.ActivityMainBinding
import ni.edu.uca.kevinperez.databinding.ActivityMenuSecundarioBinding

class MenuSecundario : AppCompatActivity() {
    lateinit var binding: ActivityMenuSecundarioBinding
    companion object{
        const val USER_EXTRA = "user_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMenuSecundarioBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val user = intent.getStringExtra(USER_EXTRA)
        val textName = findViewById<TextView>(R.id.tvBienvenido)
        textName.text = "$user"
        iniciar()
    }

    private fun iniciar() {
        binding.btnTabla.setOnClickListener{
            startActivity(Intent(this, TablaMultiplicar::class.java))
        }
        binding.btnMedia.setOnClickListener{
            startActivity(Intent(this, MediaAritmetica::class.java))
        }
    }


}
