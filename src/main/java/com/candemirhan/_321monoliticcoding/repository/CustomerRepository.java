package com.candemirhan._321monoliticcoding.repository;

import com.candemirhan._321monoliticcoding.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findAllByAddress(String address);
    List<Customer> findAllByFirstName(String firstName);
    List<Customer> findAllByFirstNameLike(String firstName);
    List<Customer> findAllByFirstNameContaining(String firstName);
    List<Customer> findByFirstNameStartsWithAndAddress(String name, String address);
    List<Customer> findAllByCreatedAtGreaterThan(Long date);
    Optional<Customer> findTopOptionalByFirstNameOrderByOidDesc(String name);
    List<Customer> findAllByCreatedAtBetween(Long startDate, Long endDate);
    List<Customer> findAllByAddressAndCreatedAtBetween(String adres,Long start, Long end);

//  @Query("SELECT c FROM Customer c WHERE c.email = ?1")
//  Customer findByEmailAdres(String emailAdres);
//  @Query(value = "SELECT c.* FROM Customer c WHERE email = ?1 and name like ?2", nativeQuery = true)
//  Customer findByEmailAddress(String emailAddress, String ad);
//  @Query("SELECT c FROM Customer c WHERE c.name = :name OR c.surname = :surname")
//  Customer findByAdOrSoyad(
//          @Param("name") String name,
//          @Param("surname") String surname);

}
