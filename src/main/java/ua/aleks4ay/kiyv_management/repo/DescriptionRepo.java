package ua.aleks4ay.kiyv_management.repo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.aleks4ay.kiyv_management.model.Description;

import java.util.List;

@Repository
public interface DescriptionRepo extends JpaRepository<Description, Long> {

    Description findByIdDocAndPosition(String idDoc, int position);
    //example from docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#repositories.query-methods.details -->
    // --> List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

    List<Description> findFirst7ByIdDoc(String idDoc);  //example: List<User> findFirst2ByOrderByLastnameAsc();

    @Query("select d from Description d where d.idDoc = :idDoc and d.position = :position")
    Description findByComplexId(@Param("idDoc") String idDoc, @Param("position") int position);

    @Override
    List<Description> findAll(Sort sort);
}
