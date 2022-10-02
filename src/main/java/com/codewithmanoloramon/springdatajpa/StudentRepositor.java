package com.codewithmanoloramon.springdatajpa;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepositor extends PagingAndSortingRepository<Student1, Long> {
    @Query("SELECT s FROM Student1 s WHERE s.email = ?1")
    Optional<Student1> findStudent1ByEnail(String email);
    @Query("SELECT s FROM  Student1  s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student1> selectStudent1WhereFirstNameAndAgeGreaterOrEqual( String firstName, Integer age);

    @Query(value = "SELECT * FROM Student1 WHERE first_name = :firstName AND age >= :age", nativeQuery = true)
    List<Student1> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstName") String firstName,
            @Param("age") Integer age
            );

    @Transactional
    @Modifying
    @Query("DELETE FROM Student1 u WHERE u.id = ?1")
    int deleteStudent1ById(Long id);
}
