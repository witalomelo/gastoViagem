package br.com.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    // função responsavel por fazer a criação da activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View Binding
//        findViewById<TextView>(R.id.button_calculate)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }


    //função responsavel pelo onClick e executar a função calculate
    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()

        }
    }

    // função de validação contemplando varias situações possíveis
    private fun isValid(): Boolean {
        return (
                binding.editDistance.text.toString() != "" &&
                        binding.textPrice.text.toString() != "" &&
                        binding.editAutonomy.text.toString() != "" &&
                        binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    //função calcular o valor gasto
    private fun calculate() {

        if (isValid()) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.textPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            binding.textViewTotalValue.text = "R$ ${"%.2f".format(totalValue)}"

        } else {
            Toast.makeText(this, R.string.validation_fill_all_fields, Toast.LENGTH_SHORT).show()
        }

    }


}