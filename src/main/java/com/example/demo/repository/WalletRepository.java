package com.example.demo.repository;

import com.example.demo.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {
    Iterable<Wallet> findAllByNameContaining(String name);

/*    @Modifying
    @Query(value = "select * from wallet where created_date like :day", nativeQuery = true)
    Iterable<Wallet> findAllByDayCreate(@Param("day") String day);*/

    @Modifying
    @Query(value = "select * from wallet where status = 1 and user_id = :id", nativeQuery = true)
    Iterable<Wallet> findAllByStatusPublicAndUser_Id(@Param("id") Long id);
    @Modifying
    @Query(value = "select * from wallet where status = 2 and user_id = :id", nativeQuery = true)
    Iterable<Wallet> findAllByStatusPrivateAndUser_Id(@PathVariable Long id);

    Iterable<Wallet> findAllByUserId(Long id);
/*    @Modifying
    @Query(value = "UPDATE wallet set status = 2 where id = :id and user_id = :userId", nativeQuery = true)
    Optional<Wallet> deleteByUserId(@Param("id") Long id, @Param("userId") Long userId);*/

}
