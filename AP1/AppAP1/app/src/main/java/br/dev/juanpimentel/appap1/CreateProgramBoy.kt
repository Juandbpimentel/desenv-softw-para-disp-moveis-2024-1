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

class CreateProgramBoy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_program_boy)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val db = databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app-database"
        ).enableMultiInstanceInvalidation()
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
        val programBoyDAO = db.programBoyDAO()
        val nomeTextEdit = findViewById<EditText>(R.id.activity_create_edit_text_nome)
        val areaAtuacaoTextEdit = findViewById<EditText>(R.id.activity_create_edit_text_area_atuacao)
        val idadeTextEdit = findViewById<EditText>(R.id.activity_create_edit_text_number_idade)
        val voltarBtn = findViewById<View>(R.id.act_create_btn_voltar)
        val criarBtn = findViewById<View>(R.id.act_create_btn_criar)

        voltarBtn.setOnClickListener {
            finish()
        }
        criarBtn.setOnClickListener {
            val booleanArray = booleanArrayOf(
                nomeTextEdit.toString().isNotEmpty(),
                areaAtuacaoTextEdit.toString().isNotEmpty(),
                idadeTextEdit.toString().isNotEmpty()
            )
            if (booleanArray.contains(false)) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            var isNomeValid = true
            var isAreaAtuacaoValid = true
            var isIdadeValid = true
            var idade = 0
            var areaAtuacao = ""
            var nome = ""
            try {
                idade = idadeTextEdit.text.toString().toInt()
                if (idade <=0)
                    throw NumberFormatException()
            } catch (e: NumberFormatException) {
                isIdadeValid = false
            }
            try {
                areaAtuacao = areaAtuacaoTextEdit.text.toString()
                if (areaAtuacao.isEmpty())
                    throw Exception()
            } catch (e: Exception) {
                isAreaAtuacaoValid = false
            }
            try {
                nome = nomeTextEdit.text.toString()
                if (nome.isEmpty())
                    throw Exception()
            } catch (e: Exception) {
                isNomeValid = false
            }
            val stringDeErro = StringBuilder()
            stringDeErro.append("Erros:")
            if (!isNomeValid) {
                stringDeErro.append("'Nome inválido' ")
            }
            if (!isAreaAtuacaoValid) {
                stringDeErro.append("'Área de atuação inválida' ")
            }
            if (!isIdadeValid) {
                stringDeErro.append("'Idade inválida'")
            }
            if (!isNomeValid || !isAreaAtuacaoValid || !isIdadeValid) {
                Toast.makeText(this, stringDeErro.toString(), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val programBoy = ProgramBoy(
                nome,
                areaAtuacao,
                idade
            )
            try {
                programBoyDAO.insert(programBoy)
                Toast.makeText(this, "ProgramBoy criado com sucesso", Toast.LENGTH_SHORT).show()
            }catch (e: Exception){
                Toast.makeText(this, "Erro ao criar ProgramBoy", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}