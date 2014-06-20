package br.com.cadore.wcvalidator.main.utils;

public class ValidationsBR {
    
    public boolean isValidCPFCNPJ(String text){
        text = text.replace(".", " ");
        text = text.replace("-", " ");
        text = text.replace("/", " ");
        text = text.replace(" ", "");
        boolean flag;
        
        if(text.length() == 11){
            flag = isValidCpf(text);
        }else if(text.length() == 14){
            flag = isValidCnpj(text);
        }else{
            flag = false;
        }
        return flag;
    }
    
    private boolean isValidCpf(String str_cpf) { // formato XXX.XXX.XXX-XX
        str_cpf = str_cpf.replace(".", " ");
        str_cpf = str_cpf.replace("-", " ");
        str_cpf = str_cpf.replace(" ", "");
        if (str_cpf.equals("00000000000") || str_cpf.equals("11111111111") || str_cpf.equals("22222222222") || str_cpf.equals("33333333333")
                || str_cpf.equals("44444444444") || str_cpf.equals("55555555555") || str_cpf.equals("66666666666") || str_cpf.equals("77777777777")
                || str_cpf.equals("88888888888") || str_cpf.equals("99999999999")) {
            return false;
        } else {
            System.out.println(str_cpf);
            if (!str_cpf.substring(0, 1).equals("")) {
                try {
                    boolean validado = true;
                    int d1, d2;
                    int digito1, digito2, resto;
                    int digitoCPF;

                    String nDigResult;
                    d1 = d2 = 0;
                    digito1 = digito2 = resto = 0;

                    for (int nCount = 1; nCount < str_cpf.length() - 1; nCount++) {
                        digitoCPF = Integer.valueOf(str_cpf.substring(nCount - 1, nCount)).intValue();

                        //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
                        d1 = d1 + (11 - nCount) * digitoCPF;

                        //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
                        d2 = d2 + (12 - nCount) * digitoCPF;
                    }

                    //Primeiro resto da divisão por 11.
                    resto = (d1 % 11);

                    //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
                    if (resto < 2) {
                        digito1 = 0;
                    } else {
                        digito1 = 11 - resto;
                    }

                    d2 += 2 * digito1;

                    //Segundo resto da divisão por 11.
                    resto = (d2 % 11);

                    //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
                    if (resto < 2) {
                        digito2 = 0;
                    } else {
                        digito2 = 11 - resto;
                    }

                    //Digito verificador do CPF que está sendo validado.
                    String nDigVerific = str_cpf.substring(str_cpf.length() - 2, str_cpf.length());

                    //Concatenando o primeiro resto com o segundo.
                    nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                    //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
                    return nDigVerific.equals(nDigResult);

                } catch (Exception e) {
                    System.err.println("Erro! " + e);

                    return false;
                }
            } else {
                return false;
            }
        }
    }

    private boolean isValidCnpj(String str_cnpj) {
        str_cnpj = str_cnpj.replace(".", " ");//onde há ponto coloca espaço
        str_cnpj = str_cnpj.replace("/", " ");//onde há barra coloca espaço
        str_cnpj = str_cnpj.replace("-", " ");//onde há traço coloca espaço
        str_cnpj = str_cnpj.replace(" ", "");
        if (str_cnpj.equals("00000000000000") || str_cnpj.equals("11111111111111") || str_cnpj.equals("22222222222222") || str_cnpj.equals("33333333333333")
                || str_cnpj.equals("44444444444444") || str_cnpj.equals("55555555555555") || str_cnpj.equals("66666666666666") || str_cnpj.equals("77777777777777")
                || str_cnpj.equals("88888888888888") || str_cnpj.equals("99999999999999")) {
            return false;
        } else {
            System.out.println(str_cnpj);
            if (!str_cnpj.substring(0, 1).equals("")) {
                try {
                    int soma = 0, dig;
                    String cnpj_calc = str_cnpj.substring(0, 12);

                    if (str_cnpj.length() != 14) {
                        return false;
                    }
                    char[] chr_cnpj = str_cnpj.toCharArray();
                    /* Primeira parte */
                    for (int i = 0; i < 4; i++) {
                        if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                            soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                            soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                        }
                    }
                    dig = 11 - (soma % 11);
                    cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                            dig);
                    /* Segunda parte */
                    soma = 0;
                    for (int i = 0; i < 5; i++) {
                        if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                            soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                        }
                    }
                    for (int i = 0; i < 8; i++) {
                        if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                            soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                        }
                    }
                    dig = 11 - (soma % 11);
                    cnpj_calc += (dig == 10 || dig == 11) ? "0" : Integer.toString(
                            dig);
                    return str_cnpj.equals(cnpj_calc);
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
