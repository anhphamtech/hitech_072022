package com.example.exercise_b2

class Cau1 {
    // ======== test khai báo=========
    var lt_mean = arrayListOf<Int>()

    constructor(lt_mean: ArrayList<Int>) {
        this.lt_mean = lt_mean
    }
    //=================================

    //fun calMeanList(lst:MutableList<Int>):Double{
    fun calMeanList(lst: ArrayList<Int>): Double {
        var s: Double = 0.0
        var mean: Double = 0.0
        lst.forEach { item ->
            s += item
        }
        lst.average()
        return s / lst.size
    }

    //fun calMeanList(lst:MutableList<Int>):Double{
    fun calMeanList1(lst: ArrayList<Int>) = lst.average()

}