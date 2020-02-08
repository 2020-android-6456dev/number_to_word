package com.converter.utils

val units = arrayOf(
    "", "One", "Two", "Three", "Four",
    "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
    "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
    "Eighteen", "Nineteen"
)

val tens = arrayOf(
    "",
    "",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety"
)

/**
 * This function converts number to words
 * @number input number
 */
fun getNumberInWords(number: Int): String {

    //Number related errors handled here
    if(number > 999999){
        throw IllegalArgumentException()
    }

    if (number < 0) {
        throw IllegalArgumentException()
    }

    if (number < 20) {
        return units[number]
    }

    if (number < 100) {
        return tens[number / 10] + (if (number % 10 != 0) " " else "") + units[number % 10]
    }
    if (number < 1000) {
        return units[number / 100] + " Hundred" + (if (number % 100 != 0) " " else "") + getNumberInWords(
            number % 100
        )
    }
    if (number < 100000) {
        return getNumberInWords(number / 1000) + " Thousand" + (if (number % 10000 != 0) " " else "") + getNumberInWords(
            number % 1000
        )
    }
    return if (number < 10000000) {
        getNumberInWords(number / 100000) + " Lakh" + (if (number % 100000 != 0) " " else "") + getNumberInWords(
            number % 100000
        )
    } else getNumberInWords(number / 10000000) + " Crore" + (if (number % 10000000 != 0) " " else "") + getNumberInWords(
        number % 10000000
    )
}

/**
 * This function converts number in string format to integer
 * @numberText takes number input in string format and returns decimal
 */
fun getDecimalFromString(numberText: String): Int{
    try {
        return numberText.trim().toInt()
    } catch (e: Exception){
        // Number related errors handled here
        // Works for any number conversion error, we can show error with message for different cases if required
        throw IllegalArgumentException()
    }
}
