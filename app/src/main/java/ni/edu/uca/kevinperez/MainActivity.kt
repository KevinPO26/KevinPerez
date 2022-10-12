package ni.edu.uca.kevinperez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ni.edu.uca.kevinperez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val usuari = "Kevin"
    val password = "1234"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        iniciar()
    }

    fun iniciar() {
        binding.btnIngresar.setOnClickListener {
            val user = binding.etID.text.toString()
            val pw = binding.etPW.text.toString()
            val usuario = Usuario(user, pw)
            validarCredenciales(user, pw, usuario)
        }
    }

    private fun validarCredenciales(user: String, pw: String, usuario: Usuario) {
        if (user.equals(usuari) && pw.equals(password)) {
            Toast.makeText(this, "BIENVENIDO", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MenuSecundario::class.java)
            intent.putExtra(MenuSecundario.USER_EXTRA, usuario.toString())
            startActivity(intent)
        } else {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }

    }
}