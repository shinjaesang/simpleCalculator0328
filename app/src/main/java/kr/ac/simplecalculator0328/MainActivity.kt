package kr.ac.simplecalculator0328

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var edit1:EditText
    lateinit var edit2:EditText
    lateinit var btnPlus:Button
    lateinit var btnMinus:Button
    lateinit var btnMultiply:Button
    lateinit var btnDivide:Button
    lateinit var btnRest:Button
    lateinit var textResult:TextView
    var result: Double? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        위젯 객체의 참조값을 필드로 선언된 참조변수에 대입
        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)
        btnPlus = findViewById<Button>(R.id.btnPlus)
        btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnDivide = findViewById<Button>(R.id.btnDivide)
        btnRest = findViewById<Button>(R.id.btnRest)
        textResult = findViewById<TextView>(R.id.textResult)

//        btnPlus.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            val num2 = edit2.text.toString().toInt()
//            result = num1 + num2
//            textResult.text = "계산 결과:" + result
//            false
//        }
//        btnMinus.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            val num2 = edit2.text.toString().toInt()
//            result = num1 - num2
//            textResult.text = "계산 결과:" + result
//            false
//        }
//        btnMultiply.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            val num2 = edit2.text.toString().toInt()
//            result = num1 * num2
//            textResult.text = "계산 결과:" + result
//            false
//        }
//        btnDivide.setOnClickListener {
//            val num1 = edit1.text.toString().toInt()
//            val num2 = edit2.text.toString().toInt()
//            result = num1 / num2
//            textResult.text = "계산 결과:" + result
//            false
//        }
        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnRest.setOnClickListener(btnListener)

    }
    var btnListener = OnClickListener{
        val num1str = edit1.text.toString()
        val num2str = edit2.text.toString()
        val num1 = num1str.toDouble()
        val num2 = num2str.toDouble()

        if(num1str == "" || num1str == ""){
            Toast.makeText(baseContext, "입력을 하지 않았습니다.", Toast.LENGTH_LONG).show()
            return@OnClickListener
        }

        when(it.id){
            R.id.btnPlus -> result = num1 + num2
            R.id.btnMinus -> result = num1 - num2
            R.id.btnMultiply -> result = num1 * num2
            R.id.btnDivide ->{
                if(num2 == 0.0){
                    Toast.makeText(baseContext, "0으로 나누면 안됩니다.", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1/num2
            }
//            R.id.btnDivide -> result = num1 / num2
            R.id.btnRest -> result = num1 % num2
        }
        textResult.text = "계산 결과: " + result
    }
}