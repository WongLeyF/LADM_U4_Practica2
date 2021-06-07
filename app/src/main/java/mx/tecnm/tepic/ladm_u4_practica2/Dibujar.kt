package mx.tecnm.tepic.ladm_u4_practica2

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.View

class Dibujar (p:MainActivity, d: SensorManager, v: SensorManager): View(p), SensorEventListener {
    var nightPic = BitmapFactory.decodeResource(resources,R.drawable.pintura2)
    var dayPic = BitmapFactory.decodeResource(resources,R.drawable.pintura1)
    var catPic = BitmapFactory.decodeResource(resources, R.drawable.cat)
    var paint1 = Sprites(0,0,nightPic)
    var paint2 = Sprites(0,0,dayPic)
    var cat = Sprites(0,100,catPic)
    var sensorX : Float = 0f
    var sensorY : Float = 0f
    var prox = 100f
    var listenerAce = d
    var listenerProx = v
    var roomDay = false


    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val paint = Paint()

        listenerAce.registerListener(this,listenerAce.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME)
        listenerProx.registerListener(this,listenerProx.getDefaultSensor(Sensor.TYPE_PROXIMITY), SensorManager.SENSOR_DELAY_NORMAL)

        paint2.pintar(c,0f,0f,paint)
        paint1.pintar(c,0f,0f,paint)
        cat.pintar(c,540+(-sensorX)*75,1000+sensorY*75,paint)


        if(roomDay==false) {
            c.drawBitmap(nightPic, 0f, 0f, paint)
        }
        else {
            c.drawBitmap(dayPic, 0f, 0f, paint)
        }
        c.drawBitmap(catPic,540+(-sensorX)*75,1000+sensorY*75,paint)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if(Sensor.TYPE_ACCELEROMETER == event!!.sensor.type){
            sensorX  = event.values[0]
            sensorY  = event.values[1]
            invalidate()
        }
        if(Sensor.TYPE_PROXIMITY == event.sensor.type){

            roomDay = event.values[0] >= 5
            prox=event.values[0]*1000
            invalidate()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

}