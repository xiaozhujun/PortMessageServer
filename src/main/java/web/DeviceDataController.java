package web;

import domain.Message;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.DeviceDataService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Controller
@RequestMapping(value = "/sensors", method = RequestMethod.GET)
public class DeviceDataController {
    @Autowired
    private DeviceDataService service;

    @RequestMapping(value = "/sensor/{id}.htm")
    @ResponseBody
    public String getSensorData(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") String id){
        Set<Message> set = service.getMsgBySensor(id);
        return getJsonp(set,request.getParameter("callback"));
    }

    @RequestMapping(value = "/sensor/{id}/{time}.htm")
    @ResponseBody
    public String getSensorTimeData(HttpServletRequest request,HttpServletResponse response,@PathVariable("id") String id,@PathVariable("time") String time){
        Message msg = service.getMsgBySensorAndTime(id,Long.parseLong(time));
        return getJsonp(msg,request.getParameter("callback"));
    }

    private String getJsonp(Object obj,String prefix){
        ObjectMapper mapper = new ObjectMapper();
        String result = prefix + "(";
        try {
            result += mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return result + ")";
    }

}
