fun main(array: Array<String>) {
    
    val intArray = arrayOf(16,20,195,9,10,18,259,1)
    println("Before Bubble Sort:")
    for(i in intArray){
        print("$i ")
    }

    bubbleSort(intArray)
    println("")

    println("After Bubble Sort:")
    for(i in intArray){
        print("$i ")
    }
}

fun bubbleSort(intArray: Array<Int>) {

    val arraySize = intArray.size - 1;
    var temp = 0;

    for(i in 0..arraySize){
        for(j in 1..(arraySize-i)){
            if(intArray[j-1] > intArray[j]){
                temp = intArray[j-1];
                intArray[j-1] = intArray[j];
                intArray[j] = temp;
            }
        }
    }
}
