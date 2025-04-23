package com.deeRav.service;

import com.deeRav.entity.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Slf4j
@Service
//@RequestScope
@SessionScope
public class ContactService {
    int count = 0;
    public ContactService(){
        System.out.println("Contact service object is created");
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSave = true;
        log.info(contact.toString());
        return isSave;
    }
}
