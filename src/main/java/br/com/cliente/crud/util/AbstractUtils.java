package br.com.cliente.crud.util;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.InputMismatchException;

public class AbstractUtils {
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

    private static String removeCaracteresEspeciais(String doc) {
        if (doc.contains(".")) {
            doc = doc.replace(".", "");
        }
        if (doc.contains("-")) {
            doc = doc.replace("-", "");
        }
        if (doc.contains("/")) {
            doc = doc.replace("/", "");
        }
        return doc;
    }

    public static boolean isCPF(String CPF) {

        CPF = AbstractUtils.removeCaracteresEspeciais(CPF);

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            return (dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10));
        } catch (InputMismatchException erro) {
            return (false);
        }
    }
}
