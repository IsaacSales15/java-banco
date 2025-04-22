package com.sales.banco.app;

import com.sales.banco.modelo.Pessoa;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Principal2 {

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Sandro Lopes", "123456467");
        Pessoa pessoa2 = new Pessoa("Mário Amaral", "346790096");

        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);

        System.out.println(pessoas);

        //Pessoa pessoa3 = pessoas.get(1);
        //System.out.println(pessoa3);

        //for (int i = 0; i < pessoas.size(); i++) {
        //System.out.println(pessoas.get(i)); }

        //for (Pessoa pessoa : pessoas) {
           // System.out.println(pessoa.getNome());
        //}

        Pessoa pessoa3 = new Pessoa("Mário Amaral", "346790096");

        //boolean existe = pessoas.contains(pessoa1);
        //System.out.println(existe);

        System.out.println(pessoa2.equals(pessoa3));

    }

}
