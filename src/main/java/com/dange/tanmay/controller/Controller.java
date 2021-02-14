package com.dange.tanmay.controller;

import com.dange.tanmay.util.Utils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @RequestMapping(method = RequestMethod.POST, value="/convert")
    @ResponseBody
    public String convertToJSON(@RequestBody String  input) {
        return Utils.prettyPrint(XML.toJSONObject(input));
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST, value="/convertXML")
    @ResponseBody
    public String convertToXML(@RequestBody String  input) {
        JSONObject json = new JSONObject(input);
        return XML.toString(json);
    }

}
