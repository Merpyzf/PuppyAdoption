package com.example.androiddevchallenge

class Repository {

    fun getPuppyList(): MutableList<Puppy> {
        val puppyList = mutableListOf<Puppy>()
        puppyList.add(Puppy("Alaskan Malamute", "girl", 2, "the adopter must really love the dog.", R.drawable.alaskanmalamute))
        puppyList.add(Puppy("Bulldog", "boy", 1, "adopt me, I will always be with you", R.drawable.bulldog))
        puppyList.add(Puppy("Chihuahua", "girl", 1, "would you give me a little bit of love for the world", R.drawable.chihuahua))
        puppyList.add(Puppy("Chinese Country Dog", "boy", 3, "I am so cute", R.drawable.chinesecountrydog))
        puppyList.add(Puppy("Golden Retriever", "girl", 3, "abandoned in the park, I picked it up and wanted to give her a home", R.drawable.goldenretriever))
        puppyList.add(Puppy("German Shepherd", "girl", 4, "it is required to have a stable work and living place, and the living room has sunlight and ventilation", R.drawable.germanshepherd))
        puppyList.add(Puppy("Golden Retriever", "boy", 3, "you won't be alone with me", R.drawable.goldenretrievera))
        puppyList.add(Puppy("Chinese Country Dog", "boy", 5, "want to eat meat", R.drawable.chinesecountrydoga))
        return puppyList
    }

}