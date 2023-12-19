package cl.fmujica.aplicacion_u1_prog_hibrida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import cl.fmujica.aplicacion_u1_prog_hibrida.Pedidos.Mesa
import cl.fmujica.aplicacion_u1_prog_hibrida.Pedidos.Menu
import cl.fmujica.aplicacion_u1_prog_hibrida.Pedidos.CuentaMesa

class MainActivity : AppCompatActivity() {
    private var etCantPastel: EditText? = null
    private var etCantCazuela: EditText? = null
    private var tvValorPastel: EditText? = null
    private var tvValorCazuela: EditText? = null
    private var tvSubtotal: EditText? = null
    private var tvPropina: EditText? = null
    private var tvTotal: EditText? = null
    private var switchPropina: Switch? = null
    private var calcularAutomaticamente = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchPropina = findViewById<Switch>(R.id.swistchPropina)
        etCantPastel = findViewById<EditText>(R.id.etCantPastel)
        etCantCazuela = findViewById<EditText>(R.id.etCantCazuela)
        tvValorPastel = findViewById<TextView>(R.id.tvValorPastel)
        tvValorCazuela = findViewById<TextView>(R.id.tvValorCazuela)
        tvSubtotal = findViewById<TextView>(R.id.tvSubtotal)
        tvPropina = findViewById<TextView>(R.id.tvPropina)
        tvTotal = findViewById<TextView>(R.id.tvTotal)
        var totalConPropina = tvSubtotal + tvPropina
        var totalSinPropina = tvSubtotal

        val textWatcher: TextWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (calcularAutomaticamente) {
                    totalConPropina()
                }
                else { totalSinPropina}
            }
        }
        etCantPastel?.addTextChangedListener(textWatcher)
        etCantCazuela?.addTextChangedListener(textWatcher)

        switchPropina?.setOnCheckedChangeListener{buttonView, isChecked ->
            calcularAutomaticamente = isChecked
        }
    }
    private fun mostrarPromedio() {
        val pedidos = ()
        val nota1 = etCantCazuela?.text.toString().toIntOrNull() ?: 1.0
        val nota2 = etCantPastel?.text.toString().toIntOrNull() ?: 1.0
        estudiante.agregarNota(nota1)
        estudiante.agregarNota(nota2)
        val total = estudiante.calcularPromedio()
        tvTotal?.setText("%.1f".format(total))
    }
}