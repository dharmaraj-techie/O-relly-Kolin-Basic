package interoperability;


import java.io.IOException;

public class TalkingToKotlin {
    public static void main(String[] args){
        /*
         * Customer is a Kotlin class
         */
        CustomerKotlin customer = new CustomerKotlin(9585,"raj","someonw@gmail.com", "23/12/91");

        // * we use the getter method , but it was declared as a property in  kotlin
        customer.getAge();

        customer.setDob("30/02/99");
/*------------------------------------------------------------------------------------------------ */
        /**
         * someProperty is declared as a property in kotlin, so you can't access it as a field
         */
        customer.getSomeProperty();

        /**
         * here someField is also a property in kotlin, but it is annotated with @JvmField
         * so that we can access it as a field in Java
         */
        String someField = customer.someField;
/*------------------------------------------------------------------------------------------------ */
        // * we can access the methods
        customer.changeStatus(Status.Current);

        // # what happens when the func have default parameter
//         ! customer.funWithDefaultParameter();
        // * the above will throw an error because it will ask for a parameter
        // * but the func in kotlin is declared with a default parameter
        // ? how to work with this

        /*
         * we have annotated the method with @JvmOverload
         */
        customer.funWithDefaultParameter1();

        /*
         * the original name of the func ins makePreferred
         * it is changed to preferential java by @JvmName
         */
        customer.preferential();

/*-------------------------------------------------------------------------------------------------*/
        // * calling top level fun from kotlin

        // here prefix is a top level function defined in the file TopLevelFunc.kt
        // when compiled it generates a TopLevel
        KotlinTopLevelFunKt.prefix("dksfj", "dsjf");

        // * when renamed
        // ? UtilityClass.prefix("dksfj", "dsjf");

/*-------------------------------------------------------------------------------------------------*/
        // * calling top level property
        KotlinTopLevelFunKt.getCopyRight();

        // * when property is declared as const it becomes field
        int field = KotlinTopLevelFunKt.year;


/*-------------------------------------------------------------------------------------------------*/

        // * working with extension function of kotlin

        // ! customer.extension()
        // here the extension function of kotlin can't be called directly
        // what we can do is call this with a different approach

        ExtensionFuncKt.extension(customer);
        // we call this be calling the file name + Kt in which we declared the extenion
        // and passing the object.

        // let's assume if I have declared the extension fun in the same class (i.e) CustomerKotlin
        // then I would need to call CustomerKotlinKt.extension(customer)

        // ? ExtensionFuncKt.extension(customer);
// ? is equivalent to
        // ? customer.extension()
    }

    /**
     * # Exception
     * @param customerKotlin
     */
    public void loadStats(CustomerKotlin customerKotlin){

        // * even though the loadStatistics throws IOException in Kotlin
        // * it can't be caught in java
        //
//?        try {
//?           customerKotlin.loadStatistics("");
//!        }catch (IOException e){  //error the method doesn't throw IOException
//?            e.printStackTrace();
//?        }

        // * here since the method is annotated we can use the IO exception
        try {
            customerKotlin.loadStatistics1("");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
