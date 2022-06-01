package com.newProject.repositories;

import java.util.List;
import java.util.Optional;

import com.newProject.models.Bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill , Long> {
    
    public static final String SELECT_FROM_BILL_MASTER_BY_BM_PRODUCT_ID = "SELECT * FROM billing_master bm where bm.bill_id = :billId";

    public static final String SELECT_FROM_BILL_MASTER_BY_BM_USER_ID = "SELECT * FROM billing_master bm where bm.user_id = :userId";

    @SuppressWarnings("unchecked")
    Bill save(Bill bill);

    @Query(value = SELECT_FROM_BILL_MASTER_BY_BM_PRODUCT_ID,nativeQuery = true)
    Optional<Bill> getByBillId(Long billId);

    @Query(value = SELECT_FROM_BILL_MASTER_BY_BM_USER_ID,nativeQuery = true)
    List<Bill> getBillByUser(Long userId);


}
