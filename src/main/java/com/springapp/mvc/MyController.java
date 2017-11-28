package com.springapp.mvc;

import com.springapp.mvc.models.ModP;
import com.springapp.mvc.models.Success;
import com.springapp.mvc.models_distant_db.Abonent;
import com.springapp.mvc.model_for_users.User;
import com.springapp.mvc.service.MyServiceClass;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/getuserdata")
public class MyController {
    @Autowired
    MyServiceClass myServiceClass;
    Success success = new Success();
    private static final Logger log = Logger.getLogger(MyController.class);

    @ResponseBody
    @RequestMapping(value = "/off",method = RequestMethod.POST)
    public Object otkluchenie(@RequestBody Abonent abonent) {
        if(abonent!=null){

           success =  myServiceClass.otkluchenie(abonent);
            return success;
        }
        success.setResult(100);
        return success;
    }
    @ResponseBody
    @RequestMapping(value = "/on",method = RequestMethod.POST)
    public Object podkluchenie(@RequestBody Abonent abonent) {
        if(abonent!=null){

            success = myServiceClass.podkluchenie(abonent);
            return success;
        }
        success.setResult(100);
        return success;
    }

    @ResponseBody
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public Object searchAbonent(@RequestBody  Abonent abonent) {

            if((abonent!=null)
                &&
                (
                (abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0)
                ||
                (abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0)
                ||
                (abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0)
                ||
                (abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0)
                ||
                (abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0)
                )
                ){
            String lenin = "Ленинский";
            String oktyabr = "Октябрьский";
            String pervomaiskiy = "Первомайский";
            String sverdlovskiy = "Свердловский";
            String fiderCostrom = "Фидер Костромская";
            String all = "Все";
            if(lenin.equals(abonent.getNregion())){
                abonent.setNregion("22");
            }
            if(oktyabr.equals(abonent.getNregion())){
                abonent.setNregion("20");
            }
            if(pervomaiskiy.equals(abonent.getNregion())){
                abonent.setNregion("21");
            }
            if(sverdlovskiy.equals(abonent.getNregion())){
                abonent.setNregion("23");
            }
            if(fiderCostrom.equals(abonent.getNregion())){
                abonent.setNregion("36");
            }
            if(all.equals(abonent.getNregion())){
                abonent.setNregion(null);
            }

            Object resultAbonent =  myServiceClass.search(abonent);
            if (resultAbonent!=null){
                return resultAbonent;
            }else{
                success.setResult(200);
                return success;
            }
        }
        success.setResult(100);
        return success;
    }
    @ResponseBody
    @RequestMapping(value = "/searchoffabonent",method = RequestMethod.POST)
    public Object searchOffAbonent(@RequestBody Abonent abonent) {

        if(abonent!=null
                &&
                (
                (abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0)
                ||
                (abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0)
                ||
                (abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0)
                ||
                (abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0)
                ||
                (abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0)
                 )
           ){

            Object  object  = myServiceClass.searchOff(abonent);
            if (object!=null){
                return object;
            }else{
                success.setResult(200);
                return success;
            }
        }
        success.setResult(100);
        return success;
    }
    @ResponseBody
    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public Object signIn(@RequestBody User user) {

        if(user!=null
                &&
                (user.getName()!=null&&user.getName()!= ""&&user.getName().length()!=0)
                &&
                (user.getPassword()!=null&&user.getPassword()!=""&&user.getPassword().length()!=0)
                ){

            success = myServiceClass.signIn(user);
            if (success!=null){
                return success;
            }else{
                success.setResult(100);
                return success;
            }
        }
        success.setResult(100);
        return success;
    }



}
