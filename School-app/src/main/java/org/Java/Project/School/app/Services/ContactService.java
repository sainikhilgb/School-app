package org.Java.Project.School.app.Services;

import lombok.extern.slf4j.Slf4j;
import org.Java.Project.School.app.Controllers.ContactController;
import org.Java.Project.School.app.models.Contacts;
import org.Java.Project.School.app.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ContactService {

    @Autowired
    public ContactRepository contactRepository;


  public boolean saveMessageDetails(Contacts contact){
      boolean isSaved = true;
      contact.setStatus(EazySchoolConstants.OPEN);
      contact.setCreateBy(EazySchoolConstants.AN0NYMOUS);
      contact.setCreateAt(LocalDateTime.now());

      int result = contactRepository.saveMessage(contact);
      if (result>0){
          isSaved = true;
      }

      return isSaved;
  }
}
