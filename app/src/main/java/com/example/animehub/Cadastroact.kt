package com.example.animehub

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.databinding.DataBindingUtil
import com.example.animehub.Home
import com.example.animehub.R
import com.example.animehub.databinding.ActivityCadastroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.animehub.MainActivity

class Cadastroact : ComponentActivity() {

    // Firebase Auth instance
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityCadastroBinding
    private lateinit var db: FirebaseFirestore // Adicione essa linha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cadastro)

        // Inicializar FirebaseAuth e Firestore
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance() // Adicione essa linha

        // Botão para voltar à página principal
        binding.backButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Botão para confirmar o cadastro
        binding.confirmButton.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordField.text.toString()
            val username = binding.usernameField.text.toString()

            // Validar os campos
            if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()) {
                registerUser(email, password, username) // Passe o username para a função
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Função para registrar o usuário no Firebase
    private fun registerUser(email: String, password: String, username: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sucesso no registro
                    val user = auth.currentUser
                    Log.d("Cadastro", "Usuário registrado com sucesso: ${user?.email}")

                    // Salvar dados do usuário no Firestore
                    saveUserToFirestore(user?.uid, username, email)

                } else {
                    // Falha no registro
                    Log.w("Cadastro", "Erro ao registrar o usuário", task.exception)
                    Toast.makeText(this, "Erro ao registrar: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    // Função para salvar os dados do usuário no Firestore
    private fun saveUserToFirestore(userId: String?, username: String, email: String) {
        val userMap = hashMapOf(
            "username" to username,
            "email" to email
        )

        // Adicionando o usuário na coleção 'users'
        userId?.let {
            db.collection("users").document(it) // Usando o userId como ID do documento
                .set(userMap)
                .addOnSuccessListener {
                    Log.d("Cadastro", "Dados do usuário salvos no Firestore com sucesso!")
                    // Navegar para a tela Home após salvar os dados
                    val intent = Intent(this, Home::class.java)
                    startActivity(intent)
                    finish()
                }
                .addOnFailureListener { e ->
                    Log.w("Cadastro", "Erro ao salvar dados do usuário: ${e.message}")
                    Toast.makeText(this, "Erro ao salvar dados: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }
}