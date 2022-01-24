package interoperability.data;

import interoperability.data.CustomerJava;

import java.util.List;

public interface CustomerRepository {
    CustomerJava getById(int Id);
    List<CustomerJava> getAll();
}
