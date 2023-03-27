package com.kushanthsliit.shopmanagement.service.impl;

import com.kushanthsliit.shopmanagement.model.BusinessRecord;
import com.kushanthsliit.shopmanagement.repository.BusinessRecordRepository;
import com.kushanthsliit.shopmanagement.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private BusinessRecordRepository businessRecordRepository;

    @Override
    public BusinessRecord addRecord(BusinessRecord businessRecord) {
        BusinessRecord br = businessRecordRepository.findByDate(businessRecord.getDate());
        if(br == null){
            return businessRecordRepository.save(businessRecord);
        }
        else {
            return null;
        }
    }

    @Override
    public List<BusinessRecord> getAllRecords() {
        return businessRecordRepository.findAllByOrderByDateDesc();
    }

    @Override
    public BusinessRecord getBusinessrecordById(long id) {
        BusinessRecord br = businessRecordRepository.findById(id).get();
        if(br != null){
            return br;
        }
        else {
            return null;
        }
    }

    @Override
    public BusinessRecord updateRecord(BusinessRecord businessRecord, long id) {
        BusinessRecord br = businessRecordRepository.findById(id).get();
        br.setDate(businessRecord.getDate() != null ? businessRecord.getDate() : br.getDate());
        br.setOysterSold(businessRecord.getOysterSold() != 0 ? businessRecord.getOysterSold() : br.getOysterSold());
        br.setTobaccoSold(businessRecord.getTobaccoSold() != 0 ? businessRecord.getTobaccoSold() : br.getTobaccoSold());
        br.setTobaccoSoldQuantity(businessRecord.getTobaccoSoldQuantity() != 0 ? businessRecord.getTobaccoSoldQuantity() : br.getTobaccoSoldQuantity());
        br.setPhoneCardsSold(businessRecord.getPhoneCardsSold() != 0 ? businessRecord.getPhoneCardsSold() : br.getPhoneCardsSold());
        br.setTotal(businessRecord.getTotal() != 0 ? businessRecord.getTotal() : br.getTotal());
        br.setShopSales(businessRecord.getShopSales() != 0 ? businessRecord.getShopSales() : br.getShopSales());
        br.setShop(businessRecord.getShop() != 0 ? businessRecord.getShop() : br.getShop());
        br.setPhoneCardsPurchased(businessRecord.getPhoneCardsPurchased() != 0 ? businessRecord.getPhoneCardsPurchased() : br.getPhoneCardsPurchased());
        br.setTobaccoPurchased(businessRecord.getTobaccoPurchased() != 0 ? businessRecord.getTobaccoPurchased() : br.getTobaccoPurchased());
        br.setTobaccoPurchasedQuantity(businessRecord.getTobaccoPurchasedQuantity() != 0 ? businessRecord.getTobaccoPurchasedQuantity() : br.getTobaccoPurchasedQuantity());
        br.setWages(businessRecord.getWages() != 0 ? businessRecord.getWages() : br.getWages());
        br.setExpenses(businessRecord.getExpenses() != 0 ? businessRecord.getExpenses() : br.getExpenses());
        br.setCommision(businessRecord.getCommision() != 0 ? businessRecord.getCommision() : br.getCommision());
        return businessRecordRepository.save(br);
    }

    @Override
    public String deleteRecord(long id) {
        if(businessRecordRepository.findById(id) != null){
            businessRecordRepository.deleteById(id);
            return "Successfully Deleted...!";
        }
        else {
            return "Can not find Record...!";
        }
    }

    @Override
    public BusinessRecordRepository.getAllSums getSummary(String startDate, String endDate) {
        return businessRecordRepository.getAllSumBetweenDates(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @Override
    public List<BusinessRecord> getAllRecordsByDateRange(String startDate, String endDate) {
        return businessRecordRepository.getRecordsBetweenDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }
}
