package service;

import dao.merchantDao;
import domain.Merchant;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class merchantService {
    private merchantDao merchantDao;

    @Autowired
    public void setMerchantDao(merchantDao merchantDao)
    {
        this.merchantDao = merchantDao;
    }

    public Merchant getInfoByID(String id)
    {
        return merchantDao.getInfoByID(id);
    }

    public boolean updateInfoByID(Merchant merchant)
    {
        return merchantDao.updateInfoByID(merchant);
    }
}
