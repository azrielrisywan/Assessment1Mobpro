package org.d3if2122.assessment1mobpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2122.assessment1mobpro.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.send.setOnClickListener {
            makeToast()
        }
    }

    fun makeToast() {
        val name = binding.namaInp.text.toString()
        val selected = binding.radioGroupMood.checkedRadioButtonId
        if (selected == -1 || TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Inputan harus diisi!", Toast.LENGTH_LONG).show()
            return
        }
        Toast.makeText(this, toastText() + " $name", Toast.LENGTH_LONG).show()
    }

    fun toastText(): String {
        var finalText = "?"
        val selected = binding.radioGroupMood.checkedRadioButtonId
        val goodMood = selected == R.id.goodRadioButton

        val goodMoodText = arrayOf(
                "I bet you are listening to good music!, ",
                "Did your mom buy you something?, ",
                "Your crush accepted you?, ",
                "Will you buy me some food then?, ",
                "Are you winning some prize?, "
            )

        val badMoodText = arrayOf(
            "Do some exercise will make your mood better!, ",
            "Lets go hangout!, ",
            "Will you join me strolling the city?, ",
            "Its okay not to be okay, ",
            "Problem never last forever, "
        )

        if (goodMood) {
            finalText = goodMoodText[Random.nextInt(0, goodMoodText.size)]
        } else {
            finalText = badMoodText[Random.nextInt(0, badMoodText.size)]
        }

        return finalText
    }
}