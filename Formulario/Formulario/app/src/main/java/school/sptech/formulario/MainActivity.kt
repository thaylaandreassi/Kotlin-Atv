package sptech.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import sptech.formulario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // sempre criaremos esse bloco para poder manipularmos os componentes do arquivo de layout XML
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root) // sempre alteramos essa linha para ficar assim

        // aqui injetamos a funcionalidade de click no tv_texto (que no binding ganha o nome em camelCase - tvTexto - automaticamente)
        binding.tvTexto.setOnClickListener {

            if (binding.etNome.text.toString().length >= 3) {

                // alterando o texto do tv_texto com o que está digitado no et_nome
                binding.tvTexto.text = binding.etNome.text

            } else {
                binding.etNome.error = "Informe pelo menos 3 letras"
            }

        }

        binding.btnSomar.setOnClickListener {
            binding.resultado.text =
                "O resultado da: ${
                    binding.etNumero1.text.toString().toInt() + binding.etNumero2.text.toString()
                        .toInt()
                }"
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.frutas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
            )
            binding.spFrutas.adapter = adapter

        }

        binding.btSpinner.setOnClickListener {
            val selecionado = binding.spFrutas.selectedItem
            binding.tvFinal.text = "Você escolhey $selecionado"
        }

        binding.spFrutas.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    TODO("Not yet implemented")
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
    }

}

