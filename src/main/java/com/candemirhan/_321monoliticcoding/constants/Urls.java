package com.candemirhan._321monoliticcoding.constants;

public class Urls {
    /**
     * 1. Basamak Versionlama
     * http://localhost:9090/mk01
     */
    public static final String VERSION = "/mk01";
    /**
     * http://localhost:9090/mk01/web
     * http://localhost:9090/mk01/api
     */
    public static final String WEB = "/web";
    public static final String API = "/api";
    /**
     * http://localhost:9090/mk01/web/musteri
     * http://localhost:9090/mk01/api/musteri     *
     */
    public static final String MUSTERI = "/musteri";
    public static final String SATIS = "/satis";
    public static final String URUN = "/urun";
    public static final String INFORMATIONS = "/informations";
    /**
     * Actions -> Methodlar
     * 1. olarak default methodları aynen kullanmak için yazalım
     */
    public static final String INDEX = "/index";
    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String SAVEALL = "/saveall";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";
    /**
     * API -> Müşteri Controller
     */
    public static final String GETBYADRES = "/getbyadres";
    public static final String GETBYAD = "/getbyad";
    public static final String GETBYADDESC = "/getbyaddesc";
    public static final String GETBYADLIKE = "/getbyadlike";
    public static final String GETBYADANDADRES = "/getbyadandadres";
    public static final String GETBYCREATEDDATE = "/getbycreateddate";
    /**
     * API -> Satış Controller
     */
    public static final String GETALLBYMUSTERIADI = "/getallbymusteriadi";
    /**
     * API -> Ürün Controller
     */
    public static final String SAVEPARAM = "/saveparam";
    public static final String SAVEPARAMDTO = "/saveparamdto";

    /**
     * API -> Information Controller
     */
    public static final String INFO = "/info";
    public static final String TITLE = "/title";

}
