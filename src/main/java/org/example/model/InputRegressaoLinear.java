package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class InputRegressaoLinear {
    private String descricaoA;
    private String descricaoB;
    private List<Double> inputA= new ArrayList<>();
    private List<Double> inputB= new ArrayList<>();

    public String getDescricaoA() {
        return descricaoA;
    }

    public void setDescricaoA(String descricaoA) {
        this.descricaoA = descricaoA;
    }

    public String getDescricaoB() {
        return descricaoB;
    }

    public void setDescricaoB(String descricaoB) {
        this.descricaoB = descricaoB;
    }

    public List<Double> getInputA() {
        return inputA;
    }

    public void setInputA(List<Double> inputA) {
        this.inputA = inputA;
    }

    public List<Double> getInputB() {
        return inputB;
    }

    public void setInputB(List<Double> inputB) {
        this.inputB = inputB;
    }
}
