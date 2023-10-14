package com.udemy.workshopmongo.controller.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
}
