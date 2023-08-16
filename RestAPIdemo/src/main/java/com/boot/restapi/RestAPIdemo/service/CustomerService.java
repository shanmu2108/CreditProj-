package com.boot.restapi.RestAPIdemo.service;


import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.exception.RecordNotFoundException;
import com.boot.restapi.RestAPIdemo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public long getCustomersCount(){
        return  customerRepository.count();
    }
    public List<Customer> getAllCustomers(){
        return this.customerRepository.findAll();
    }
    public Customer getCustomerByCustomerId(int customerid){
        return this.customerRepository.findBycustomerid(customerid);
    }
    public List<Customer> getCustomerByfirst(String first){
        return this.customerRepository.findCustomerByfirst(first);}

    public Customer addCustomer(Customer customer){
        return this.customerRepository.insert(customer);}
    public long deleteById(int customerid){
        return this.customerRepository.deleteCustomerBycustomerid(customerid);}
public Customer updateById(int customerid, Customer customer){
    Customer updatedcustomer = customerRepository.findBycustomerid(customerid);
    updatedcustomer.setDob(customer.getDob());
    updatedcustomer.setFirst(customer.getFirst());
    updatedcustomer.setGender(customer.getGender());
    updatedcustomer.setLast(customer.getLast());
    customerRepository.save(updatedcustomer);
    return customer;}


//    public EmployeePerPageResponse getEmployeesByPagination(int pageno, int size) {
//        Pageable pageable = PageRequest.of(pageno, size);
//        Page<Employee> page = repository.findAll( pageable);
//        int totalPages = page.getTotalPages();
//        long totalElements = page.getTotalElements();
//        int noofelements = page.getNumberOfElements();
//        int pagesize = page.getSize();

    //    public void updateById(int customerid, Customer customer){
//        Customer updatedcustomer = customerRepository.findBycustomerid(customerid);
//        updatedcustomer.setDob(customer.getDob());
//        updatedcustomer.setFirst(customer.getFirst());
//        updatedcustomer.setGender(customer.getGender());
//        updatedcustomer.setLast(customer.getLast());
//        customerRepository.save(updatedcustomer);
//
//    }
//    public long deleteByFirstName(String first){
//        return this.customerRepository.deleteCust(first);}
////        Customer deletedcustomer =customerRepository.findBycustomerid(customerid);
//////        ObjectId _id=deletedcustomer.get_id();
//////        customerRepository.deleteById(_id);
////        customerRepository.delete(deletedcustomer);
//    }

//        public Customer addCustomer(Customer customer) throws RecordExistsException {
//            if (customerRepository.existsById((long)(customer.getCustomer_id()))){
//                throw new RecordExistsException("Customer exists");
//            }
//            return this.customerRepository.save(customer);
//        }

//    public Customer updateCustomer(Customer customer){
//        return this.customerRepository.save(customer);
//    }

//        public Customer getCustomerbyId(long customer_id){
//        Optional<Customer> optcus = customerRepository.findById(customer_id);
//        return optcus.get();
//        }
//        public List<Customer> getCustomerByCustomer_Id(long customer_id){
//        return this.customerRepository.findByCustomer_Id(customer_id);
//        }
//    public Customer getCustomerByFirstname(String first){
//        Optional<Customer> opt = customerRepository.findCustomerByFirst(first);
//        return opt.get(); }
//    public List<Customer> getCustomersByGender(String gender) {
//        return this.customerRepository.findCustomerBygender(gender);
//    }

//        return opt.get(); }
    }


