package com.kushanthsliit.shopmanagement.repository;

import com.kushanthsliit.shopmanagement.dto.SumResponse;
import com.kushanthsliit.shopmanagement.model.BusinessRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.SqlResultSetMapping;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BusinessRecordRepository extends JpaRepository<BusinessRecord, Long> {

    BusinessRecord findByDate(LocalDate date);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.oyster_sold) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfOysterSold(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.tobacco_sold) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfTobacoSold(@Param("startDate") LocalDate startDate,
                                              @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.tobacco_sold_quantity) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfTobacoSoldQuantity(@Param("startDate") LocalDate startDate,
                                              @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.phone_cards_sold) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfPhoneCardsSold(@Param("startDate") LocalDate startDate,
                                              @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.total) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfZTotal(@Param("startDate") LocalDate startDate,
                                                  @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.shop_sales) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfShopSales(@Param("startDate") LocalDate startDate,
                                          @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.shop) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfShop(@Param("startDate") LocalDate startDate,
                                             @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.phone_cards_purchased) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfPhoneCardsPurchased(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.tobacco_purchased_quantity) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfTobaccoPurchasedQuantity(@Param("startDate") LocalDate startDate,
                                                       @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.tobacco_purchased) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfTobaccoPurchased(@Param("startDate") LocalDate startDate,
                                                    @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(br.wages) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfWages(@Param("startDate") LocalDate startDate,
                                                    @Param("endDate") LocalDate endDate);
    @Query(nativeQuery = true,
            value = "SELECT SUM(br.expenses) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfExpenses(@Param("startDate") LocalDate startDate,
                                         @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT SUM(commision) " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    double getSumOfCommition(@Param("startDate") LocalDate startDate,
                                        @Param("endDate") LocalDate endDate);

    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    List<BusinessRecord> getRecordsBetweeenDateRange(@Param("startDate") LocalDate startDate,
                                                     @Param("endDate") LocalDate endDate);

    /*@Query(nativeQuery = true,
            value = "SELECT SUM(br.wages) AS sumOfWages, SUM(br.tobacco_sold) AS sumOfTobaccoSold " +
                    "FROM public.business_record br " +
                    "WHERE br.date BETWEEN :startDate AND :endDate")
    @SqlResultSetMapping(
            name = "SumResponse",
            classes = @ConstructorResult(
                    targetClass = SumResponse.class,
                    columns = {
                            @ColumnResult(name = "sumOfWages", type = Double.class),
                            @ColumnResult(name = "sumOfTobaccoSold", type = Double.class)
                    }
            )
    )
    SumResponse getSum(@Param("startDate") LocalDate startDate,
                       @Param("endDate") LocalDate endDate);*/

}
