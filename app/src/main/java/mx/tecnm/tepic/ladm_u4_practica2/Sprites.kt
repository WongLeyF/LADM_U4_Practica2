package mx.tecnm.tepic.ladm_u4_practica2

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint


class Sprites(x: Int, y: Int, b: Bitmap) {
    var x = 0f
    var y = 0f
    var ancho = 0f
    var alto = 0f
    var icono : Bitmap?= b
    var invisible = false
    var tipo = 3

    init {
        this.x = x.toFloat()
        this.y = y.toFloat()
        ancho = icono!!.width.toFloat()
        alto = icono!!.height.toFloat()
        tipo = 3
    }

    fun pintar(c: Canvas, x1:Float,y2:Float, p: Paint){
        if(!this.invisible){
            when(tipo){
                3->{
                    c.drawBitmap(icono!!,x1,y2,p)
                }
            }
        }
    }

}