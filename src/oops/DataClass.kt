package oops

//have to do

data class Employee(val id:Int, val name:String)

 class EmployeeClass(val id:Int, val name:String)

/*
Creating a data class remove a lot of boilerplate code , (i.e) we don't need to create getters and setter,
toString methods and equalsTo method they are automatically done
 */

fun main(){
    /**
     * usage of data class
     */
    val ram = Employee(1, "ram")
    val ram1 = Employee(1, "ram")
    val ajaiRam = ram.copy(id = 2)
    val ashokRam = Employee(3,"Ashok")

    println(ram)
    //Employee(id=1, name=ram)
    println(ashokRam)
    //Employee(id=3, name=Ashok)
    if(ram == ram1) println("they are the same")
    //they are the same

//----------------------------------------------------------------------------------------

    /**
     * disadvantages of not having a data class
     */
    val raj = EmployeeClass(1,"fg")
    val raj2 = EmployeeClass(1,"fg")
    //we don't get the copy method because its not data class
    //    val raj3 =  raj2.copy()

    println(raj)
    //oops.EmployeeClass@29453f44
    //it prints the pointer not toString method
    if(raj == raj2) println("they are the same ") else println("unknown ")
    //unknown
    //even though they are same , since equlas method is not implemented so it's returning false
}