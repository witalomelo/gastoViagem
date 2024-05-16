package br.com.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gastoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()

        }
    }

    private fun calculate() {
        val distance = binding.editDistance.text.toString().toFloat()
        val price = binding.textPrice.text.toString().toFloat()
        val autonomy = binding.editAutonomy.text.toString().toFloat()

        val totalValue = (distance * price) / autonomy
        binding.textViewTotalValue.text =  "R$ ${"%.2f".format(totalValue)}"

        // Toast.makeText(this, totalValueStr, Toast.LENGTH_SHORT).show()

    }


}