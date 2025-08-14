//package bookmanagement.eventregistration.errorController;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.error.ErrorAttributeOptions;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.context.request.ServletWebRequest;
//
//import java.util.Map;
//
//@RestController
//public class UsererrorController implements ErrorController {
//
//    @Autowired
//    private ErrorAttributes errorAttributes;
//
//    @RequestMapping("/error")
//    public Map<String, Object> handleError(HttpServletRequest request) {
//        ServletWebRequest webRequest = new ServletWebRequest(request);
//        Map<String, Object> attributes = errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.defaults());
//        Integer status = (Integer)attributes.get("status");
//        if(status == 404)
//        {
//            attributes.put("error", "path is not available! make sure the url is correct");
//        }
//
//        attributes.forEach((key, value) -> {
//            System.out.println(key + ": " + value);
//        });
//
//        return attributes;
//    }
//}
