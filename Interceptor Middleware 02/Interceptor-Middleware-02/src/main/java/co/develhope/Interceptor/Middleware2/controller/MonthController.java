package co.develhope.Interceptor.Middleware2.controller;

import co.develhope.Interceptor.Middleware2.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping("")
    public Month getAMonth(HttpServletRequest request){

       return  (Month) request.getAttribute("MonthNumber");



    }


}
