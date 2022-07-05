package br.com.cliente.crud.util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class MaskUtil {
    public static String getCpfWithMask(String nuCpf) {
        try {
            if (nuCpf == null || nuCpf.trim().length() == 0) {
                return "";
            }
            MaskFormatter cpfFormat = new MaskFormatter("###.###.###-##");
            cpfFormat.setValueContainsLiteralCharacters(false);
            return cpfFormat.valueToString(nuCpf.trim());
        } catch (ParseException e) {
            System.out.println("[ERROR] Erro ao aplicar a máscara no CPF. " + e);
        }
        return null;
    }

    public static String getTelWithMask(String nuTelefone) {
        try {
            if (nuTelefone == null || nuTelefone.trim().length() == 0) {
                return "";
            }
            MaskFormatter format;
            if (nuTelefone.length() == 11) {
                format = new MaskFormatter("(##) # ####-####");
            } else {
                format = new MaskFormatter("(##) ####-####");
            }
            format.setValueContainsLiteralCharacters(false);
            return format.valueToString(nuTelefone.trim());
        } catch (ParseException e) {
            System.out.println("[ERROR] Erro ao aplicar a máscara no telefone. " + e);
        }
        return null;
    }

    public static String getCepWithMask(String nuCep) {
        try {
            if (nuCep == null || nuCep.trim().length() == 0) {
                return "";
            }
            MaskFormatter format = new MaskFormatter("#####-###");
            format.setValueContainsLiteralCharacters(false);
            return format.valueToString(nuCep.trim());
        } catch (ParseException e) {
            System.out.println("[ERROR] Erro ao aplicar a máscara no CEP. " + e);
            return "";
        }
    }

    public static String removeCepCpfCnpjTelMask(String str) {
        if (str == null || str.trim().length() == 0) {
            return "";
        }
        return str.trim()
                .replaceAll(" ", "")
                .replaceAll("\\-", "")
                .replaceAll("\\.", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\/", "");
    }
}
