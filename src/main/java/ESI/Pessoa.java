package ESI;

public class Pessoa {

    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) throws IllegalArgumentException{
       setNome(nome);
       setCpf(cpf);
    }

    //Fornecido prof
    public static boolean validarCpf(String cpf){
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (caso inválido)
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Cálculo do primeiro dígito verificador
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit >= 10) {
            firstDigit = 0;
        }

        // Verifica o primeiro dígito verificador
        if (firstDigit != (cpf.charAt(9) - '0')) {
            return false;
        }

        // Cálculo do segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += (cpf.charAt(i) - '0') * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit >= 10) {
            secondDigit = 0;
        }

        // Verifica o segundo dígito verificador
        return secondDigit == (cpf.charAt(10) - '0');
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException{
        if(!validarCpf(cpf) || cpf == null){
            throw new IllegalArgumentException("CPF Inválido");
        }

        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    //Nome não pode ser nulo, vazio, ou conter menos que duas palavras
    public void setNome(String nome) throws  IllegalArgumentException {
        if(nome == null || nome.isEmpty() || nome.trim().split("\\s").length > 2){
           throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

}
