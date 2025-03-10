package org.Java.Project.School.app.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GobalEceptionController {


    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(Exception exception){

        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        errorPage.addObject("errorMsg", exception.getMessage());
        return errorPage;
    }
}
