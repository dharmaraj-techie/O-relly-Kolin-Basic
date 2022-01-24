package interoperability

import interoperability.data.CustomerJava

fun main() {
    val customerJava = CustomerJava()

    // * here the method neverBeNull is annotated with @NotNull annotation in java
    val s: String = customerJava.neverBeNull()

    /**
     * this method is not annotated in java ,
     * so it can be booth null (String?) and non-null (String)
     */
    val n: String? = customerJava.canBeNull()
}