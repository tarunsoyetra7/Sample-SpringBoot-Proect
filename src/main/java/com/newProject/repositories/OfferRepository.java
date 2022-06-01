package com.newProject.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.newProject.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer , Long> {
     
    public static final String DELETE_OFFER_MASTER_BY_OFFER_ID = "DELETE FROM OFFER_MASTER o WHERE o.offer_id =:Id";

    public static final String SELECT_FROM_OFFER_MASTER = "SELECT * FROM OFFER_MASTER";

    public static final String SELECT_FROM_OFFER_MASTER_BY_OFFER_ID = "SELECT * FROM OFFER_MASTER o where o.offer_id = :Id";

    public static final String SELECT_FROM_OFFER_MASTER_BY_CAT_ID = "SELECT * FROM OFFER_MASTER o WHERE o.cat_id = :catId";

    public static final String SELECT_FROM_OFFER_MASTER_BY_CAT_ID_BETWEEN_CURDATE = "SELECT * FROM OFFER_MASTER o WHERE (:now between o.offer_s_date AND o.offer_e_date) AND o.cat_id = :catId";

    @SuppressWarnings("unchecked")
    Offer save(Offer offerDeatil);

    @Query(value = SELECT_FROM_OFFER_MASTER , nativeQuery = true)
    List<Offer> getAllOffers();

    Optional<Offer> findById(Long Id);

    @Modifying
    @Query(value = DELETE_OFFER_MASTER_BY_OFFER_ID , nativeQuery = true)
    void deleteById(Long Id);

    @Query(value = SELECT_FROM_OFFER_MASTER_BY_OFFER_ID , nativeQuery = true)
    Optional<Offer> check(Long Id);
    
    @Query(value = SELECT_FROM_OFFER_MASTER_BY_CAT_ID , nativeQuery = true)
    Optional<Offer> getOfferDetailsByCatid(Long catId);

    @Query(value = SELECT_FROM_OFFER_MASTER_BY_CAT_ID_BETWEEN_CURDATE , nativeQuery = true)
    Optional<Offer> getOfferByCatIdBtwnCurDate(@Param("now") LocalDate now,@Param("catId") Long catId);
    
}
