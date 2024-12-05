package br.com.api.endereco.configuration.constants;

public enum LogConstant {

    DATABASE("DATABASE"),
    EXTERNAL_API("EXTERNAL_API");

    LogConstant(String value) {
        this.value = value;
    }

    private final String value;

    public String value() {
        return value;
    }

}
