package org.d3if2145.calc2d

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import org.d3if2145.calc2d.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pilihButton.setOnClickListener {
            pilihBD()
        }
        binding.hitungButton.setOnClickListener {
            hitungCalc()
        }
        binding.resetButton.setOnClickListener {
            resetCalc()
        }
    }

    private fun pilihBD(){
        val selectedBD = binding.radioGroup.checkedRadioButtonId

        val persegi = selectedBD == R.id.persegiButton
        val pPanjang = selectedBD == R.id.pPanjangButton
        val segitiga = selectedBD == R.id.segitigaButton
        val lingkaran = selectedBD == R.id.lingkaranButton

        if (selectedBD == -1) {
            Toast.makeText(this, R.string.bd_invalid, Toast.LENGTH_SHORT).show()
            return
        } else if (persegi) {
            binding.panjangHint.setHint(R.string.sisi)
            binding.lebarHint.setHint(R.string.sisi)
        } else if (pPanjang) {
            binding.panjangHint.setHint(R.string.panjang)
            binding.lebarHint.setHint(R.string.lebar)
        } else if (segitiga) {
            binding.panjangHint.setHint(R.string.alas)
            binding.lebarHint.setHint(R.string.tinggi)
        } else if (lingkaran) {
            binding.panjangHint.setHint(R.string.pi)
            binding.lebarHint.setHint(R.string.jari)
        }
    }

    @SuppressLint
    private fun hitungCalc() {
        val selectedBD = binding.radioGroup.checkedRadioButtonId
        val panjang = binding.panjangInp.text.toString()
        val lebar = binding.lebarInp.text.toString()

        val persegi = selectedBD == R.id.persegiButton
        val pPanjang = selectedBD == R.id.pPanjangButton
        val segitiga = selectedBD == R.id.segitigaButton
        val lingkaran = selectedBD == R.id.lingkaranButton

        if (selectedBD == -1) {
            Toast.makeText(this, R.string.bd_invalid, Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(panjang)) {
            Toast.makeText(this, R.string.input_invalid, Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(lebar)) {
            Toast.makeText(this, R.string.input_invalid, Toast.LENGTH_SHORT).show()
            return
        }

        if (persegi) {
            //Rumus LK
            val luas = panjang.toFloat() * lebar.toFloat()
            val keliling = 2*panjang.toFloat() + 2*lebar.toFloat()
            //Hasil kalkulasi
            binding.textHasilLuas.text = getString(R.string.luas_hasil, luas)
            binding.textHasilKeliling.text = getString(R.string.keliling_hasil, keliling)
        } else if (pPanjang) {
            //Rumus LK
            val luas = panjang.toFloat() * lebar.toFloat()
            val keliling = 2*panjang.toFloat() + 2*lebar.toFloat()
            //Hasil kalkulasi
            binding.textHasilLuas.text = getString(R.string.luas_hasil, luas)
            binding.textHasilKeliling.text = getString(R.string.keliling_hasil, keliling)
        } else if (segitiga) {
            //Rumus LK
            val luas = panjang.toFloat()/2 * lebar.toFloat()
            val keliling = panjang.toFloat() * 3
            //Hasil kalkulasi
            binding.textHasilLuas.text = getString(R.string.luas_hasil, luas)
            binding.textHasilKeliling.text = getString(R.string.keliling_hasil, keliling)
        } else if (lingkaran) {
            //Rumus LK
            val luas = panjang.toFloat() * lebar.toFloat() * lebar.toFloat()
            val keliling = 2*panjang.toFloat() * lebar.toFloat()
            //Hasil kalkulasi
            binding.textHasilLuas.text = getString(R.string.luas_hasil, luas)
            binding.textHasilKeliling.text = getString(R.string.keliling_hasil, keliling)
        }
    }
    private fun resetCalc() {
        binding.panjangInp.setText("")
        binding.lebarInp.setText("")
        binding.textHasilLuas.text = ""
        binding.textHasilKeliling.text = ""
        binding.radioGroup.clearCheck()
    }
}