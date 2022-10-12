package ni.edu.uca.kevinperez

import java.lang.StringBuilder

class Usuario(private var user: String, private var pw: String) {
    override fun toString(): String {
        return "Bienvenido $user"
    }
}