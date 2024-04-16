package br.com.buscacep.modulos;

public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private int ddd;

    public Endereco(EnderecoViaCep meuEndereco) {
        this.cep = meuEndereco.cep();
        this.logradouro = meuEndereco.logradouro();
        this.bairro = meuEndereco.bairro();
        this.localidade = meuEndereco.localidade();
        this.uf = meuEndereco.uf();
        this.ddd = Integer.valueOf(meuEndereco.ddd());
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public int getDdd() {
        return ddd;
    }
}
