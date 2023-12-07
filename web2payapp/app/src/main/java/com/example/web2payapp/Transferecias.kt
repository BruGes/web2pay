
package com.example.web2payapp

import kotlin.random.Random

data class Transferecias(val id:Int = getID() ,val valor_cad:String,val tipo_cad:String, val c_d:String)
{
    companion object {
        fun getID(): Int {
            //val random = Random().nextInt(100)
            return Random.nextInt(100)
        }
    }
}