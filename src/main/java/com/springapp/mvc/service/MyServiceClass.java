package com.springapp.mvc.service;


import com.springapp.mvc.models.Success;
import com.springapp.mvc.models_distant_db.Abonent;
import com.springapp.mvc.models_local_db.Chinameters;
import com.springapp.mvc.models_local_db.Counterr;
import com.springapp.mvc.model_for_users.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.format.DateTimeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class MyServiceClass {

    @Autowired
    @Qualifier(value = "sessionFactoryDistant")
    SessionFactory sessionFactoryDistant;
    @Autowired
    @Qualifier(value = "sessionFactoryLocalDb")
    SessionFactory sessionFactoryLocalDb;
    @Autowired
    @Qualifier(value = "sessionFactory")
    SessionFactory session;
    Date date = new Date();
    String name_user = null;
    Timestamp time = new Timestamp(date.getTime());
    private static final Logger log = Logger.getLogger(MyServiceClass.class);

    public Object search(Abonent abonent) {
        if (abonent != null &&
                (
                        (abonent.getCspot() != null && abonent.getCspot() != "" && abonent.getCspot().length() != 0)
                                ||
                                (abonent.getCspot2() != null && abonent.getCspot2() != "" && abonent.getCspot2().length() != 0)
                                ||
                                (abonent.getAddress1() != null && abonent.getAddress1() != "" && abonent.getAddress1().length() != 0)
                                ||
                                (abonent.getAddress2() != null && abonent.getAddress2() != "" && abonent.getAddress2().length() != 0)
                                ||
                                (abonent.getNregion() != null && abonent.getNregion() != "" && abonent.getNregion().length() != 0)
                )
                ) {
            Criteria criteria = sessionFactoryDistant.getCurrentSession().createCriteria(Abonent.class);
            if (abonent.getNregion() != null && abonent.getNregion() != "" && abonent.getNregion().length() != 0) {
                criteria.add(Restrictions.eq("nregion", abonent.getNregion()));
            }
            if (abonent.getCspot() != null && abonent.getCspot() != "" && abonent.getCspot().length() != 0) {
                criteria.add(Restrictions.eq("cspot", abonent.getCspot() + "%"));
                Abonent a = (Abonent) criteria.uniqueResult();
                if (a != null) {
                    return a;
                }
            }
            if (abonent.getCspot2() != null && abonent.getCspot2() != "" && abonent.getCspot2().length() != 0) {
                criteria.add(Restrictions.like("cspot2", abonent.getCspot2() + "%"));
            }
            if (abonent.getAddress1() != null && abonent.getAddress1() != "" && abonent.getAddress1().length() != 0) {
                criteria.add(Restrictions.like("address1", abonent.getAddress1() + "%"));
            }
            if (abonent.getAddress2() != null && abonent.getAddress2() != "" && abonent.getAddress2().length() != 0) {
                criteria.add(Restrictions.like("address2", abonent.getAddress2() + "%"));
            }
            List result_search = criteria.list();
            if (result_search != null && result_search.size() != 0) {
                return result_search;
            }

        }
        return null;
    }


    public Success otkluchenie(Abonent abonent) {
        if (abonent.getCspot() != null && abonent.getCspot() != "" && abonent.getCspot().length() != 0 && abonent.getNamitype() != null && abonent.getNamitype() != "" && abonent.getNamitype().length() != 0) {
            if (abonent.getNamitype().equals("1")) {
                Criteria criteria = sessionFactoryLocalDb.getCurrentSession().createCriteria(Counterr.class);
                criteria.add(Restrictions.eq("ls", abonent.getCspot()));
                Counterr cnt = (Counterr) criteria.uniqueResult();
                if (cnt == null) {
                    Counterr counterr = new Counterr();
                    if (abonent.getCspot() != null) {
                        counterr.setLs(abonent.getCspot());
                    }
                    if (abonent.getCspot2() != null) {
                        counterr.setFio_customer(abonent.getCspot2());
                    }
                    if (abonent.getCcounter() != null) {
                        counterr.setCounters(abonent.getCcounter());
                    }
                    if (abonent.getAddress1() != null) {
                        counterr.setAdress(abonent.getAddress1());
                    }
                    if (abonent.getAddress2() != null) {
                        counterr.setDom(abonent.getAddress2());
                    }
                    counterr.setUsers("altynbek");

                    sessionFactoryLocalDb.getCurrentSession().save(counterr);
                    Success success = new Success();
                    success.setResult(200);
                    return success;

                } else {
                    Success success = new Success();
                    success.setResult(300);
                    return success;
                }
            } else if (abonent.getNamitype().equals("2") || abonent.getNamitype().equals("4") || abonent.getNamitype().equals("3")) {
                Criteria criteria = sessionFactoryLocalDb.getCurrentSession().createCriteria(Chinameters.class);
                criteria.add(Restrictions.eq("cust_code", abonent.getCspot()));
                Chinameters chch = (Chinameters) criteria.uniqueResult();
                if (chch == null) {
                    Chinameters chinameters = new Chinameters();
                    if (abonent.getCcounter() != null) {
                        chinameters.setMeter_no(abonent.getCcounter());
                    }
                    if (abonent.getNregion() != null) {
                        int i = Integer.valueOf(abonent.getNregion());
                        chinameters.setRegion(i);
                    }
                    if (abonent.getDgarb() != null) {
                        int i = Integer.valueOf(abonent.getDgarb());
                        chinameters.setCommand(i);
                    }
                    if (abonent.getCcounter2() != null) {
                        chinameters.setMeter_type(abonent.getCcounter2());
                    }
                    if (abonent.getCcounter20() != null) {
                        int i = Integer.valueOf(abonent.getCcounter20());
                        chinameters.setType_mvalue(i);
                    }
                    if (abonent.getCspot2() != null) {
                        chinameters.setCust_name(abonent.getCspot2());
                    }
                    if (abonent.getCspot() != null) {
                        chinameters.setCust_code(abonent.getCspot());
                    }
                    if (abonent.getAddress1() != null) {
                        chinameters.setCust_adr1(abonent.getAddress1());
                    }
                    if (abonent.getAddress2() != null) {
                        chinameters.setCust_adr2(abonent.getAddress2());
                    }
                    chinameters.setUser_name("altynbek");
                    java.sql.Timestamp ti = new Timestamp(new Date().getTime());
                    chinameters.setTimesend(ti);
                    sessionFactoryLocalDb.getCurrentSession().save(chinameters);

                    Success success = new Success();
                    success.setResult(200);
                    return success;

                } else {
                    Success success = new Success();
                    success.setResult(300);
                    return success;
                }
            }
        }
        Success success = new Success();
        success.setResult(100);

        return success;
    }

    public Success podkluchenie(Abonent abonent) {
        if (abonent.getCspot() != null && abonent.getCspot() != "" && abonent.getCspot().length() != 0 && abonent.getNamitype() != null && abonent.getNamitype() != "" && abonent.getNamitype().length() != 0) {
            if (abonent.getNamitype().equals("1")) {
                Counterr counterr = new Counterr();
                if (abonent.getCspot() != null) {
                    counterr.setLs(abonent.getCspot());
                }
                if (abonent.getCspot2() != null && abonent.getCspot2() != "" && abonent.getCspot2().length() != 0) {
                    counterr.setFio_customer(abonent.getCspot2());
                }
                if (abonent.getCcounter() != null && abonent.getCcounter() != null && abonent.getCcounter().length() != 0) {
                    counterr.setCounters(abonent.getCcounter());
                }
                if (abonent.getAddress1() != null && abonent.getAddress1() != null && abonent.getAddress1().length() != 0) {
                    counterr.setAdress(abonent.getAddress1());
                }
                if (abonent.getAddress2() != null && abonent.getAddress2() != null && abonent.getAddress2().length() != 0) {
                    counterr.setDom(abonent.getAddress2());
                }
                if (abonent.getNregion() != null && abonent.getNregion() != "" && abonent.getNregion().length() != 0) {
                    Integer i = Integer.valueOf(abonent.getNregion());
                    counterr.setRaion(i);
                }

                counterr.setTel("");
                counterr.setComand(1);
                counterr.setAkt("0.0");
                counterr.setDebetors("0.0");
                counterr.setPenya("0.0");

                counterr.setKto(name_user);
                java.sql.Timestamp ti = new Timestamp(new Date().getTime());
                counterr.setTimesend(ti);

                counterr.setUsers("android");

                sessionFactoryLocalDb.getCurrentSession().save(counterr);
                Success success = new Success();
                success.setResult(200);
                return success;


            } else if (abonent.getNamitype().equals("2") || abonent.getNamitype().equals("4") || abonent.getNamitype().equals("3")) {
                Criteria criteria = sessionFactoryLocalDb.getCurrentSession().createCriteria(Chinameters.class);
                criteria.add(Restrictions.eq("cust_code", abonent.getCspot()));
                Chinameters chch = (Chinameters) criteria.uniqueResult();
                if (chch == null) {
                    Chinameters chinameters = new Chinameters();
                    if (abonent.getCcounter() != null) {
                        chinameters.setMeter_no(abonent.getCcounter());
                    }
                    if (abonent.getNregion() != null) {
                        int i = Integer.valueOf(abonent.getNregion());
                        chinameters.setRegion(i);
                    }
                    if (abonent.getDgarb() != null) {
                        int i = Integer.valueOf(abonent.getDgarb());
                        chinameters.setCommand(i);
                    }
                    if (abonent.getCcounter2() != null) {
                        chinameters.setMeter_type(abonent.getCcounter2());
                    }
                    if (abonent.getCcounter20() != null) {
                        int i = Integer.valueOf(abonent.getCcounter20());
                        chinameters.setType_mvalue(i);
                    }
                    if (abonent.getCspot2() != null) {
                        chinameters.setCust_name(abonent.getCspot2());
                    }
                    if (abonent.getCspot() != null) {
                        chinameters.setCust_code(abonent.getCspot());
                    }
                    if (abonent.getAddress1() != null) {
                        chinameters.setCust_adr1(abonent.getAddress1());
                    }
                    if (abonent.getAddress2() != null) {
                        chinameters.setCust_adr2(abonent.getAddress2());
                    }

                    chinameters.setUser_name("android");
                    chinameters.setCommand(1);
                    chinameters.setNote(name_user);
                    chinameters.setDebt_energy("0.0");
                    chinameters.setDebt_akt("0.0");
                    chinameters.setDebt_penalty("0.0");
                    chinameters.setCust_phone("");

                    chinameters.setTimesend(time);

                    chinameters.setUser_name("altynbek");

                    sessionFactoryLocalDb.getCurrentSession().save(chinameters);
                    Success success = new Success();
                    success.setResult(200);
                    return success;

                } else {
                    Success success = new Success();
                    success.setResult(300);
                    return success;
                }
            }
        }
            Success success = new Success();
            success.setResult(100);

            return success;
        }






    public Success signIn(User user){
        User resultUser;
        if (user!=null&&user.getName()!=null&&user.getName()!=""&&user.getPassword()!=null&&user.getPassword()!=""){
            Criteria  criteria = session.getCurrentSession().createCriteria(User.class);
            criteria.add(Restrictions.eq("name",user.getName()));
            criteria.add(Restrictions.eq("password",user.getPassword()));
            resultUser = (User) criteria.uniqueResult();
            if(resultUser!=null){
                name_user = resultUser.getName();
                Success success = new Success();
                success.setResult(200);
                return success;
            }
            Success success = new Success();
            success.setResult(100);
            return success;
        }
        Success success = new Success();
        success.setResult(100);
        return success;
    }

    public Object searchOff(Abonent abonent){
        if(abonent!=null&&
                (
                                (abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0)
                                ||
                                (abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0)
                                ||
                                (abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0)
                                ||
                                (abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0)
                                ||
                                (abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0)
                )
                ){
            Criteria criteria = sessionFactoryLocalDb.getCurrentSession().createCriteria(Counterr.class);
                    if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0){
                        criteria.add(Restrictions.eq("ls",abonent.getCspot()));
                        Counterr cnt = (Counterr)criteria.uniqueResult();
                        if(cnt!=null){
                            return cnt;
                        }
                    }
                            if(abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0){
                                criteria.add(Restrictions.like("fio_customer",abonent.getCspot2()));
                            }if(abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0){
                                criteria.add(Restrictions.like("adress",abonent.getAddress1()));
                            }if(abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0){
                                criteria.add(Restrictions.like("dom",abonent.getAddress2()));
                            }if(abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0){
                               Integer i = Integer.valueOf(abonent.getNregion());
                                criteria.add(Restrictions.like("raion",i));
                            }
                                    List result_search = criteria.list();
                                    if(result_search!=null&&result_search.size()!=0){
                                        return result_search;
                                    }
            Criteria criteria2 = sessionFactoryLocalDb.getCurrentSession().createCriteria(Chinameters.class);
                    if(abonent.getCspot()!=null&&abonent.getCspot()!=""&&abonent.getCspot().length()!=0){
                        criteria2.add(Restrictions.eq("cust_code",abonent.getCspot()));
                        Chinameters chch = (Chinameters)criteria2.uniqueResult();
                        if(chch!=null){
                            return chch;
                        }
                    }
                            if(abonent.getCspot2()!=null&&abonent.getCspot2()!=""&&abonent.getCspot2().length()!=0){
                                criteria2.add(Restrictions.like("cust_name",abonent.getCspot2()));
                            }if(abonent.getAddress1()!=null&&abonent.getAddress1()!=""&&abonent.getAddress1().length()!=0){
                                criteria2.add(Restrictions.like("cust_adr1",abonent.getAddress1()));
                            }if(abonent.getAddress2()!=null&&abonent.getAddress2()!=""&&abonent.getAddress2().length()!=0){
                                 criteria2.add(Restrictions.like("cust_adr2",abonent.getAddress2()));
                            }if(abonent.getNregion()!=null&&abonent.getNregion()!=""&&abonent.getNregion().length()!=0){
                                 Integer i = Integer.valueOf(abonent.getNregion());
                                 criteria2.add(Restrictions.like("region",i));
                            }
                                    List result_search2 = criteria2.list();
                                    if(result_search2!=null&&result_search2.size()!=0){
                                        return result_search2;
                                    }

        }
        return null;
    }
}
