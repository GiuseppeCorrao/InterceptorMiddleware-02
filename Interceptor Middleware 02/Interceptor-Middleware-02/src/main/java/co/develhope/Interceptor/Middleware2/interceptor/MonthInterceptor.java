package co.develhope.Interceptor.Middleware2.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import co.develhope.Interceptor.Middleware2.entities.Month;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public List<Month> monthList = List.of(
            new Month(0, "Jenuary", "Gennaio", "Januar"),
            new Month(1, "February", "Febbraio", "Februar"),
            new Month(3, "April", "aprile", "April"),
            new Month(4, "May", "maggio", "Mai"),
            new Month(5, "June", "giugno", "Juni")
            );


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains("/months")) {
            String monthNumber = request.getHeader("monthNumber");
            if (monthNumber != null) {
                int intNumber = Integer.parseInt(monthNumber);
                Optional<Month> monthFound = monthList.stream()
                        .filter(singleMonth -> singleMonth.getMonthNumber() == intNumber)
                        .findFirst();
                if (monthFound.isPresent()) {
                    request.setAttribute("MonthInterceptor-month", monthFound.get());
                } else {
                    request.setAttribute("MonthInterceptor-month",
                            new Month(0, "nope", "nope", "nope"));
                }
                response.setStatus(200);
                return true;
            } else {
                response.setStatus(400);
                return false;
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
