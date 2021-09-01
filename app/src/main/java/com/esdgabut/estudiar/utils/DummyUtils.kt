package com.esdgabut.estudiar.utils

import com.esdgabut.estudiar.data.model.TentorModel
import java.util.*

fun createTentor(): TentorModel {
    return TentorModel(
        name = "Yasaka Shrine",
        city = "Kyoto",
        url = "https://source.unsplash.com/Xq1ntWruZQI/600x800"
    )
}

fun createTentors(): List<TentorModel> {
    val tentors = ArrayList<TentorModel>()
    tentors.add(
        TentorModel(
            name = "Yasaka Shrine",
            city = "Kyoto",
            url = "https://source.unsplash.com/Xq1ntWruZQI/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Fushimi Inari Shrine",
            city = "Kyoto",
            url = "https://source.unsplash.com/NYyCqdBOKwc/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Bamboo Forest",
            city = "Kyoto",
            url = "https://source.unsplash.com/buF62ewDLcQ/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Brooklyn Bridge",
            city = "New York",
            url = "https://source.unsplash.com/THozNzxEP3g/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Empire State Building",
            city = "New York",
            url = "https://source.unsplash.com/USrZRcRS2Lw/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "The statue of Liberty",
            city = "New York",
            url = "https://source.unsplash.com/PeFk7fzxTdk/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Louvre Museum",
            city = "Paris",
            url = "https://source.unsplash.com/LrMWHKqilUw/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Eiffel Tower",
            city = "Paris",
            url = "https://source.unsplash.com/HN-5Z6AmxrM/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Big Ben",
            city = "London",
            url = "https://source.unsplash.com/CdVAUADdqEc/600x800"
        )
    )
    tentors.add(
        TentorModel(
            name = "Great Wall of China",
            city = "China",
            url = "https://source.unsplash.com/AWh9C-QjhE4/600x800"
        )
    )
    return tentors
}