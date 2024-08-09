package br.dev.juanpimentel.appap1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room.databaseBuilder
import br.dev.juanpimentel.appap1.Databases.AppDatabase
import br.dev.juanpimentel.appap1.Entities.ProgramBoy
import br.dev.juanpimentel.appap1.Entities.Todo

class CreateTodo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_todo)
        val db = databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).enableMultiInstanceInvalidation()
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        val todoDAO = db.todoDAO()
        val tituloTextEdit = findViewById<EditText>(R.id.activity_create_todo_edit_text_titulo)
        val descricaoTextEdit = findViewById<EditText>(R.id.activity_create_todo_edit_text_descricao)
        val voltarBtn = findViewById<View>(R.id.act_create_todo_btn_voltar)
        val criarBtn = findViewById<View>(R.id.act_create_todo_btn_salvar)

        voltarBtn.setOnClickListener {
            finish()
        }
        criarBtn.setOnClickListener {
            val booleanArray = booleanArrayOf(
                tituloTextEdit.toString().isNotEmpty(),
                descricaoTextEdit.toString().isNotEmpty(),
            )
            if (booleanArray.contains(false)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var isTituloValid = true
            var isDescricaoValid = true
            var descricao = ""
            var titulo = ""
            try {
                descricao = descricaoTextEdit.text.toString()
                if (descricao.isEmpty())
                    throw Exception()
            } catch (e: Exception) {
                isDescricaoValid = false
            }
            try {
                titulo = tituloTextEdit.text.toString()
                if (titulo.isEmpty())
                    throw Exception()
            } catch (e: Exception) {
                isTituloValid = false
            }
            val stringDeErro = StringBuilder()
            stringDeErro.append("Erros:")
            if (!isTituloValid) {
                stringDeErro.append("'Titulo inválido' ")
            }
            if (!isDescricaoValid) {
                stringDeErro.append("'Descrição inválida' ")
            }
            if (!isTituloValid || !isDescricaoValid) {
                Toast.makeText(this, stringDeErro.toString(), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newTodo = Todo(
                titulo,
                descricao
            )
            try {
                todoDAO.insert(newTodo)
                Toast.makeText(this, "Todo criado com sucesso", Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                Toast.makeText(this, "Erro ao criar Todo", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}