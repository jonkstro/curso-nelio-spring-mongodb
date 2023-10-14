package com.udemy.workshopmongo.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
 * Essa classe irá decodificar a URL codificada.
 * Por exemplo: o JS quando mandamos bom dia, irá
 * nos retornar: bom%20dia
 */
public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            /*
             * Se der algum erro na hora de decodificar a URL
             * será simplesmente retornado uma string vazia
             */
            return "";
        }
    }

    public static Date convertDate(String dateString, Date defaultDate) {
        // A maioria dos frontends enviam nesse formato
        // Crie um SimpleDateFormat com o formato desejado
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // Obtenha o TimeZone local do usuário
        TimeZone timeZone = TimeZone.getDefault();

        // Defina o TimeZone no SimpleDateFormat
        sdf.setTimeZone(timeZone);

        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
