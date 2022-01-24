package interoperability

import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.jvm.Throws

class CustomerKotlin(val cusId: Long, val name: String, private val phoneNumber: String, var dob: String = "") {

    val age: Int
        get() {
            val cal = Calendar.getInstance()
            val sdf = SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
            cal.time = sdf.parse(dob) // all done
            return Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR)
        }

    /**
     * this is a property in kotlin because
     * the getters and setters are created for it by the compiler,
     * but in java these are fields, to make it a property you have to create your own getters and setter
     */
    val someProperty = "value"

    /**
     * to make a field that is accessible as a field in java we need @JvmField annotation
     * this make this property as a field (i.e) it doesn't have getters and setters for this
     */
    @JvmField val someField = "this is a field"


    fun changeStatus(status :Status){
    }

    /**
     * method with default parameters
     * without any annotation so this can't be used in java
     */
    fun funWithDefaultParameter(status: Status = Status.Current){
    }


    /**
     * method with default Parameters
     * it's also annotated with [@JvmOverloads]
     * what it does is it create the overloaded method
      */
    @JvmOverloads fun funWithDefaultParameter1(status: Status = Status.Current){
    }

    /**
     * for some reason you want to call this method differently in java
     * we use the JvmName
     */
    @JvmName("preferential")
    fun makePreferred(){
    }

    /**
     * this method throws an IOException
     * But it can't be utilised in java
     */
    fun loadStatistics(fileName: String){
        if(fileName.isBlank()){
            throw IOException("file name can't be blank")
        }
    }

    /**
     * this method throws an IOException
     * to utilised in java we annotate it with @Throws(IOException::class)
     */
    @Throws(IOException::class)fun loadStatistics1(fileName: String){
        if(fileName.isBlank()){
            throw IOException("file name can't be blank")
        }
    }
}

enum class Status {
    Current,
    Past
}
