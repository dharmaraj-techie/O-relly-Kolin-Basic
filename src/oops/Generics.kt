package oops

//TODO("need to read again")
interface Repository<T>{
    fun getById(id: Int) : T
    fun getAll(): List<T>
}

class GenericRepository<T> : Repository<T> {
    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }

    override fun getById(id: Int): T {
        TODO("Not yet implemented")
    }
}


interface Repo{
    //Generic function
    fun <T>getById(id:Int):T
    fun <Entity>getAll(): Entity
}


fun main(){
    val customerRepo = GenericRepository<Customer>()
    val employeeRepo = GenericRepository<Employee>()
}