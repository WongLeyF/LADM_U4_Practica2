package mx.tecnm.tepic.ladm_u4_practica2

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tecnm.tepic.ladm_u4_practica2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManagerMov : SensorManager
    lateinit var sensorManagerProx : SensorManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sensorManagerMov = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManagerProx = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        setContentView(Dibujar(this,sensorManagerMov,sensorManagerProx))
    }
    override fun onSensorChanged(event: SensorEvent?) {

        val mov = Intent(this,Dibujar::class.java)
        mov.putExtra("X",event!!.values[0])
        mov.putExtra("Y", event.values[1])
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}