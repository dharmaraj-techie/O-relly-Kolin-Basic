package oops


enum class Status {
    LOADING,
    SUCCESS,
    FAILED
}

enum class DAYS(val dayName: String, val number: Int) {
    SUNDAY("sun", 0){
        override fun toText(): String {
            return toString()
        }

        override fun toString(): String {
            return "no work day"
        }
    },
    MONDAY("mon", 1) {
        override fun toText(): String {
            return "the 1st day"
        }
    },
    TUESDAY("tue", 2) {
        override fun toText(): String {
            return "another day of the week"
        }
    },
    WEDNESDAY("wed", 3) {
        override fun toText(): String {
            return "mid day most people will start planning for weekends"
        }
    },
    THURSDAY("thu", 4) {
        override fun toText(): String {
            TODO("Not yet implemented")
        }
    },
    FRIDAY("fri", 5) {
        override fun toText(): String {
            TODO("Not yet implemented")
        }
    },
    SATURDAY("sat", 6) {
        override fun toText(): String {
            return "party !!!!!!!!!!"
        }
    };

    abstract fun toText(): String
}

fun main() {
    val currentStage = Status.LOADING

    println(currentStage)
    //LOADING
    println(currentStage.name)
    //LOADING
    println(currentStage.ordinal)
    //0
    println(Status.FAILED.ordinal)
    //2

    when (currentStage) {
        Status.SUCCESS -> println("success")
        Status.LOADING -> println("Loading")
        Status.FAILED -> println("failed")
    }
    //loading

    for (s in Status.values()) {
        println(s)
    }
    //LOADING
    //SUCCESS
    //FAILED
//-------------------------------------------------------------------------------------------

    val day = DAYS.MONDAY

    println(day)
    println(day.dayName)
    println(day.number)
    println(day.ordinal)
    //MONDAY
    //mon
    //1
    //1

    println(DAYS.valueOf("TUESDAY"))
    //TUESDAY
    //valueOf returns the enum

    println(DAYS.SUNDAY)
    //no work day

    println(DAYS.SATURDAY.toText())
    //party !!!!!!!!!!

}

