package com.marinaskevin.relationships.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.relationships.models.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();

    // get all dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();

    // get all the names of the dojos
    @Query("SELECT d.name From Dojo d")
    List<String> findAllDojosNames();

    // passing params and filtering (still retrieves a list)
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    List<Dojo> getDojoWhereId(Long id);

    // passing params and filtering
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);

    // Note the int type. It is because it returns the number of rows affected
    @Modifying
    @Query("update Dojo d set d.name = ?1 WHERE d.id = ?2")
    int setNameForOne(String name, Long id);

    @Modifying
    @Query("update Dojo d set d.name = ?1")
    int setNameForAll(String name);

    @Modifying
    @Query("delete Dojo d WHERE d.id = ?1")
    int deleteOneDojo(Long id);

    // Select all, we get a list of Dojo objects back.
    @Query(value="SELECT * from dojos", nativeQuery=true)
    List<Dojo> findAllDojosWithNativeQuery();

    // get all the names of the dojos with id. If we want to select specific column, we will get a list of Object arrays because it is no longer Dojo objects. Each index of the array will be the column selected respectively. Therefore 0 = id column, 1 = name column
    @Query(value="SELECT id, name from dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();

    // get one dojo
    //@Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
    //Dojo getDojoWhereId(Long id);

    // inner join retrieving only the dojos
    @Query("SELECT d FROM Dojo d JOIN d.ninjas n")
    List<Dojo> joinDojosAndNinjas();

    // inner join retrieving dojos and ninjas
    @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
    List<Object[]> joinDojosAndNinjas2();
}
