package oops

/**
 * abstract class have abstract methods and abstracts state
 */
abstract class StoreEntity() {
    /**
     * this is an abstract state,
     * this needs to be implemented the class which extends this abstract class
     */
    abstract val id: Int

    /**
     * abstract class can also have an implemented state
     */
    val implementedState = 0

    /**
     * abstract method which needs to be implemented in child class
     */
    abstract fun store()

    /**
     * fully implemented method inside abstract class
     */
    fun implementedMethod() { //this is implemented method }

        /**
         * the class extending abstract class
         */
        class Employee : StoreEntity() {
            /**
             * implemented state of the abstract class,
             * we can also have it as a constructor parameter instead of state
             */
            override val id: Int
                get() = TODO("Not yet implemented")

            /**
             * implemented member function
             */
            override fun store() {
                TODO("Not yet implemented")
            }
        }

        class Employer(override val id: Int) : StoreEntity() {
            override fun store() {
                TODO("Not yet implemented")
            }
        }


    }
}

