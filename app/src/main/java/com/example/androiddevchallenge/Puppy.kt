package com.example.androiddevchallenge

import java.io.Serializable

class Puppy : Serializable {
    var variety: String
    var gender: String
    var age: Int = 0
    var moreInfo: String
    var photo: Int = 0

    constructor(variety: String, gender: String, age: Int, moreInfo: String, photo: Int) {
        this.variety = variety
        this.gender = gender
        this.age = age
        this.moreInfo = moreInfo
        this.photo = photo
    }
}