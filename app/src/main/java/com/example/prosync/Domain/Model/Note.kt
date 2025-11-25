package com.example.prosync.Domain.Model

data class Note(
        val ID: Int=0,
        val Title:String,
        val Description:String,
        val Updatedate:Long=System.currentTimeMillis(),
        val issync: Boolean=false
        )
